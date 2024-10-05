package com.ms.movement.service.domain.models;

import com.ms.movement.service.domain.enums.TypeMoveEnum;
import lombok.Data;

@Data
public class Movement {

    private Integer id;

    private TypeMoveEnum typeMovement;

    private Float amount;

    private Integer accountId;

}
