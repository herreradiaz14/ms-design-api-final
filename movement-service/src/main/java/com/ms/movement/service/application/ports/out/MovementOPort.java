package com.ms.movement.service.application.ports.out;

import com.ms.movement.service.domain.models.Movement;

public interface MovementOPort {
    Movement save(Movement movement);
}
