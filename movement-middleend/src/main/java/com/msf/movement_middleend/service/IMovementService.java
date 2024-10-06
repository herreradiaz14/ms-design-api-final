package com.msf.movement_middleend.service;

import com.msf.movement_middleend.domain.Movement;

import java.util.List;

public interface IMovementService {

    Movement createMovement(Movement movement);
    List<Movement> getMovements(Integer accountId);
}
