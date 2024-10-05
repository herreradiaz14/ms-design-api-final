package com.ms.account_service.infrastructure.adapters.out.repositories;

import com.ms.account_service.infrastructure.adapters.out.entities.AccountEntity;
import com.ms.account_service.infrastructure.adapters.out.enums.CurrencyEnumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    @Query("SELECT COUNT(u) FROM AccountEntity u WHERE u.currencyType = :currency")
    long countAccountByCurrency(@Param("currency") CurrencyEnumEntity currency);

    @Query("SELECT u FROM AccountEntity u WHERE u.customerId = :idCustomer")
    List<AccountEntity> accountByCustomerId(@Param("idCustomer") Integer idCustomer);

    //@Query("UPDATE AccountEntity SET amount = :amountCta WHERE id = :idCta")
    //AccountEntity updateMountAccount(@Param("idCta") Integer id, @Param("amountCta") Double amount);
}
