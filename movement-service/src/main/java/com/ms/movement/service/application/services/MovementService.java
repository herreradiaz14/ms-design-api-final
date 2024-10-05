package com.ms.movement.service.application.services;

import com.ms.movement.service.application.ports.in.MovementIPort;
import com.ms.movement.service.application.ports.out.MovementOPort;
import com.ms.movement.service.domain.models.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService implements MovementIPort {

    private final MovementOPort movementOPort;

    @Override
    public Movement createMovement(Movement movement){
        return movementOPort.save(movement);
    }

    @Override
    public List<Movement> getMovements(Integer accountId){
        return movementOPort.getMovements(accountId);
    }
}
