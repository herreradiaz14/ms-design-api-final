package com.ms.account.middleend.service.impl;

import com.ms.account.middleend.client.AccountServiceClient;
import com.ms.account.middleend.domain.Account;
import com.ms.account.middleend.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountServiceClient accountServiceClient;

    @Override
    public Account createAccount(Account account) {
        return accountServiceClient.createAccount("asw","asw", account).getBody();
    }

    @Override
    public Account getAccount(Integer id){
        return accountServiceClient.getAccount("aws","aws", id).getBody();
    }

    @Override
    public List<Account> getAccounts(Integer idCustomer){
        return accountServiceClient.getAccounts("aws", "aws", idCustomer).getBody();
    }

    @Override
    public Account updateAccount(Integer id, Account account){
        return accountServiceClient.updateAccount("aws", "aws", id, account).getBody();
    }
}
