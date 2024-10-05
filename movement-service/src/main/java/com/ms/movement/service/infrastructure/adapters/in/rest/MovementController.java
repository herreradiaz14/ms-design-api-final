package com.ms.movement.service.infrastructure.adapters.in.rest;

import com.ms.movement.service.application.ports.in.MovementIPort;
import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.infrastructure.adapters.in.rest.mappers.MovementDtoMapper;
import com.ms.movement.service.server.MovementsApi;
import com.ms.movement.service.server.models.MovementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class MovementController implements MovementsApi {

    private final MovementIPort movementIPort;
    private final MovementDtoMapper movementDtoMapper;

    @Override
    public ResponseEntity<MovementDto> createMovement(String xCmClientRequestId, String xCmClientUserAgent, MovementDto movementDto) {
        Movement movement = movementDtoMapper.toMovement(movementDto);

        MovementDto movementSaveDto= movementDtoMapper.toMovementDto(
                movementIPort.createMovement(movement)
        );

        return new ResponseEntity<>(movementSaveDto, HttpStatus.CREATED);
    }


}
