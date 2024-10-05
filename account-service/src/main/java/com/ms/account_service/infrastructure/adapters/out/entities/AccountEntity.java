package com.ms.account_service.infrastructure.adapters.out.entities;

import com.ms.account_service.infrastructure.adapters.out.enums.CurrencyEnumEntity;
import com.ms.account_service.infrastructure.adapters.out.enums.StatusEnumEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "T_ACCOUNTS")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cta_id", nullable = false)
    private Integer id;

    @Column(name = "cta_num_account", nullable = false, unique = true)
    private String numberAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "cta_currency", nullable = false)
    private CurrencyEnumEntity currencyType;

    @Column(name = "cta_amount", nullable = false)
    private Double amount;

    @Column(name = "cta_customer_id", nullable = false)
    private Integer customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "cta_status", nullable = false)
    private StatusEnumEntity status;
}
