package com.ms.movement.service.infrastructure.adapters.out.entities;

import com.ms.movement.service.infrastructure.adapters.out.enums.CurrencyEnum;
import com.ms.movement.service.infrastructure.adapters.out.enums.StatusEnum;
import lombok.Data;

@Data
public class Account {

    private Integer id;

    private String numberAccount;

    private CurrencyEnum currencyType;

    private float amount;

    private Integer customerId;

    private StatusEnum status;
}
