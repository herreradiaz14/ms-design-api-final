package com.ms.account.middleend.domain;

import com.ms.account.middleend.enums.CurrencyEnum;
import com.ms.account.middleend.enums.StatusEnum;
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
