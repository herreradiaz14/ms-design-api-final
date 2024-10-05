package com.ms.account_service.infrastructure.adapters.in.rest.mappers;

import com.ms.account.service.server.models.AccountDto;
import com.ms.account.service.server.models.AccountsDtoInner;
import com.ms.account_service.domain.models.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountDtoMapper {

    AccountDto toAccountDto(Account account);
    Account toAccount(AccountDto accountDto);
    List<AccountsDtoInner> toAccountListDto(List<Account> accountList);
}
