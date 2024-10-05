package com.ms.account_service.application.services;

import com.ms.account_service.application.ports.in.AccountIPort;
import com.ms.account_service.application.ports.out.AccountOPort;
import com.ms.account_service.domain.enums.StatusEnum;
import com.ms.account_service.domain.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountIPort {

    private final AccountOPort accountOPort;

    @Override
    public Account createAccount(Account account) {
        account.setStatus(StatusEnum.ACTIVA);
        return accountOPort.save(account);
    }

    @Override
    public Account getAccount(Integer id){
        return accountOPort.getAccount(id);
    }

    @Override
    public List<Account> getAccounts(Integer idCustomer){
        return accountOPort.getAccounts(idCustomer);
    }

    @Override
    public Account updateAccount(Integer id, Account account) {
        return accountOPort.updateAccount(id, account);
    }
}
