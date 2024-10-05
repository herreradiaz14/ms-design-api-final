package com.ms.account.middleend.service;

import com.ms.account.middleend.domain.Account;

import java.util.List;

public interface IAccountService {

    Account createAccount(Account account);

    Account getAccount(Integer id);

    List<Account> getAccounts(Integer idCustomer);

    Account updateAccount(Integer id, Account account);
}
