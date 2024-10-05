package com.ms.movement.service.application.ports.in;

import com.ms.movement.service.domain.models.Movement;

import java.util.List;

public interface MovementIPort {

    Movement createMovement(Movement movement);
    List<Movement> getMovements(Integer accountId);
}
