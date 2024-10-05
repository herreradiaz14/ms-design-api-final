package com.ms.account_service.infrastructure.adapters.out.mappers;

import com.ms.account_service.domain.models.Account;
import com.ms.account_service.infrastructure.adapters.out.entities.AccountEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountEntityMapper {

    AccountEntity toAccountEntity(Account account);
    Account toAccount(AccountEntity account);
    List<Account> toAccountList(List<AccountEntity> accountEntities);
}
