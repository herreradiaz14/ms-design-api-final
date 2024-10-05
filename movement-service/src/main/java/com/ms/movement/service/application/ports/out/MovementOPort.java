package com.ms.movement.service.application.ports.out;

import com.ms.movement.service.domain.models.Movement;

import java.util.List;

public interface MovementOPort {
    Movement save(Movement movement);
    List<Movement> getMovements(Integer accountId);
}
