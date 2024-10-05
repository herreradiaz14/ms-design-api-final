package com.ms.movement.service.infrastructure.adapters.out.mappers;


import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.infrastructure.adapters.out.entities.MovementEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementEntityMapper {

    MovementEntity toMovementEntity(Movement movement);
    Movement toMovement(MovementEntity movement);
    List<Movement> toMovementList(List<MovementEntity> movementEntities);
}
