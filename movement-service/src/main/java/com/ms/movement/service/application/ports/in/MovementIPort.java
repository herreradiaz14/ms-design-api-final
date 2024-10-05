package com.ms.movement.service.application.ports.in;

import com.ms.movement.service.domain.models.Movement;

public interface MovementIPort {

    Movement createMovement(Movement movement);
}
