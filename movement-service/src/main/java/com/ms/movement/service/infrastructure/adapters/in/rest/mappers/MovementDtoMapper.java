package com.ms.movement.service.infrastructure.adapters.in.rest.mappers;

import com.ms.movement.service.domain.models.Movement;
import com.ms.movement.service.server.models.MovementDto;
import com.ms.movement.service.server.models.MovementsDtoInner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementDtoMapper {
    MovementDto toMovementDto(Movement movement);
   Movement toMovement(MovementDto movementDto);
    List<MovementsDtoInner> toMovementListDto(List<Movement> movementList);
}
