package com.ms.movement.service.infrastructure.adapters.out.entities;


import com.ms.movement.service.infrastructure.adapters.out.enums.TypeMoveEnumEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "T_MOVMENTS")
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ctr_id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ctrl_t_movement", nullable = false)
    private TypeMoveEnumEntity typeMovement;

    @Column(name="ctr_amount")
    private Float amount;

    @Column(name ="ctr_a_id",nullable = false)
    private Integer accountId;
}
