package com.ms.movement.service.infrastructure.adapters.out;


import com.ms.movement.service.application.ports.out.MovementOPort;
import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.infrastructure.adapters.out.entities.MovementEntity;
import com.ms.movement.service.infrastructure.adapters.out.mappers.MovementEntityMapper;
import com.ms.movement.service.infrastructure.adapters.out.repositories.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MovementAdapter implements MovementOPort {

    private final MovementRepository movementRepository;
    private final MovementEntityMapper movementEntityMapper;

    @Override
    public Movement save(Movement movement) {
        MovementEntity movementEntity = movementEntityMapper.toMovementEntity(movement);
        Movement movementSaved= movementEntityMapper.toMovement(
          movementRepository.save(movementEntity)
        );
        return movementSaved;
    }

    @Override
    public List<Movement> getMovements(Integer accountId){

        List<MovementEntity> movementsList = movementRepository.movementByAccountId(accountId);

        if (movementsList != null && !movementsList.isEmpty()) {
            return movementEntityMapper.toMovementList(movementsList);
        }
        else {
            return null;
        }

    }

}
