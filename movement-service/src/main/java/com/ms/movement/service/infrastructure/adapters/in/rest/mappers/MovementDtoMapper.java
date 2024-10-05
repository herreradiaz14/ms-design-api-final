package com.ms.movement.service.infrastructure.adapters.in.rest.mappers;

import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.server.models.MovementDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementDtoMapper {
    MovementDto toMovementDto(Movement movement);
   Movement toMovement(MovementDto movementDto);
}
