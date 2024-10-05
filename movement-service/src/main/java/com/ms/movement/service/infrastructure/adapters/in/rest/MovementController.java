package com.ms.movement.service.infrastructure.adapters.in.rest;

import com.ms.movement.service.application.ports.in.MovementIPort;
import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.infrastructure.adapters.in.rest.mappers.MovementDtoMapper;
import com.ms.movement.service.infrastructure.adapters.out.entities.Account;
import com.ms.movement.service.infrastructure.adapters.out.rest.client.AccountServiceClient;
import com.ms.movement.service.server.MovementsApi;
import com.ms.movement.service.server.models.MovementDto;
import com.ms.movement.service.server.models.MovementsDtoInner;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class MovementController implements MovementsApi {

    private final MovementIPort movementIPort;
    private final MovementDtoMapper movementDtoMapper;
    private final AccountServiceClient accountServiceClient;

    @Override
    public ResponseEntity<MovementDto> createMovement(String xCmClientRequestId, String xCmClientUserAgent, MovementDto movementDto) {
        Movement movement = movementDtoMapper.toMovement(movementDto);
        Integer accountId = movement.getAccountId();
        ResponseEntity<Account> accountResponse = accountServiceClient.getAccount(xCmClientRequestId, xCmClientUserAgent, accountId);
        if (accountResponse.getStatusCode() != HttpStatus.OK || accountResponse.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String tipoMovement = movement.getTypeMovement().toString();
        float amount = movement.getAmount();
        float totalAmount = accountResponse.getBody().getAmount();

        if(amount < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(tipoMovement.equals("RETIRO")){
            if(amount > totalAmount){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            amount = amount * -1;
        }

        Account cta = new Account();
        cta.setAmount(amount);

        ResponseEntity<Account> updateResponse = accountServiceClient.updateAccount(xCmClientRequestId, xCmClientUserAgent, accountId, cta);

        if (updateResponse.getStatusCode() != HttpStatus.OK || updateResponse.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MovementDto movementSaveDto= movementDtoMapper.toMovementDto(
                movementIPort.createMovement(movement)
        );

        return new ResponseEntity<>(movementSaveDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<MovementsDtoInner>> getMovements(String xCmClientRequestId, String xCmClientUserAgent, Integer accountId){

        List<Movement> movementList = movementIPort.getMovements(accountId);

        if(Objects.isNull(movementList)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<MovementsDtoInner> movementDtoGet = movementDtoMapper.toMovementListDto(movementList);
        return new ResponseEntity<>(movementDtoGet, HttpStatus.OK);
    }

}
