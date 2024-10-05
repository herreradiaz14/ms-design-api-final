package com.ms.account_service.application.ports.in;

import com.ms.account_service.domain.models.Account;

import java.util.List;

public interface AccountIPort {

    Account createAccount(Account account);
    Account getAccount(Integer id);
    List<Account> getAccounts(Integer idCustomer);

    Account updateAccount(Integer id, Account account);
}
