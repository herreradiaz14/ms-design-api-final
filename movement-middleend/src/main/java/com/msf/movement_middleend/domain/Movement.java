package com.msf.movement_middleend.domain;

import com.msf.movement_middleend.domain.enums.TypeMoveEnum;
import lombok.Data;

@Data
public class Movement {

    private Integer id;

    private TypeMoveEnum typeMovement;

    private Float amount;

    private Integer accountId;

}
