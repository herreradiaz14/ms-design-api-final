package com.ms.account_service.domain.models;

import com.ms.account_service.domain.enums.CurrencyEnum;
import com.ms.account_service.domain.enums.StatusEnum;
import lombok.Data;

@Data
public class Account {

    private Integer id;

    private String numberAccount;

    private CurrencyEnum currencyType;

    private Double amount;

    private Integer customerId;

    private StatusEnum status;
}
