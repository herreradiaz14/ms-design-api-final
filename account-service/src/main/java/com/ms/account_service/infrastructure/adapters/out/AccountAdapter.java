package com.ms.account_service.infrastructure.adapters.out;

import com.ms.account_service.domain.models.Account;
import com.ms.account_service.infrastructure.adapters.out.entities.AccountEntity;
import com.ms.account_service.infrastructure.adapters.out.repositories.AccountRepository;
import com.ms.account_service.infrastructure.adapters.out.mappers.AccountEntityMapper;
import com.ms.account_service.application.ports.out.AccountOPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountAdapter implements AccountOPort {

    private final AccountRepository accountRepository;
    private final AccountEntityMapper accountEntityMapper;

    @Override
    public Account save(Account account) {

        String inicio = "40";
        if(account.getCurrencyType().toString().equals("DOLAR")){
            inicio = inicio + "1";
        }else if(account.getCurrencyType().toString().equals("SOL")){
            inicio = inicio + "2";
        }

        AccountEntity accountEntity = accountEntityMapper.toAccountEntity(account);

        long max = accountRepository.countAccountByCurrency(accountEntity.getCurrencyType());
        int identificador = (int) max + 1;
        String result = String.format("%07d", identificador);
        inicio = inicio + result;
        accountEntity.setNumberAccount(inicio);

        Account accountSaved = accountEntityMapper.toAccount(accountRepository.save(accountEntity));
        return accountSaved;
    }

    @Override
    public Account getAccount(Integer id){
        Optional<AccountEntity> accountFind = accountRepository.findById(id);
        return accountFind.map(accountEntityMapper::toAccount).orElse(null);
    }

    @Override
    public List<Account> getAccounts(Integer idCustomer){

        List<AccountEntity> accountsList = accountRepository.accountByCustomerId(idCustomer);
        return accountEntityMapper.toAccountList(accountsList);
    }

    @Override
    public Account updateAccount(Integer id, Account account){
        AccountEntity accountEntity = accountEntityMapper.toAccountEntity(account);
        Optional<AccountEntity> accountFind = accountRepository.findById(id);
        Double amount = accountFind.get().getAmount();
        amount = amount + accountEntity.getAmount();

        if (accountFind.isPresent()) {
            AccountEntity accountEntity1 = accountFind.get();
            accountEntity1.setAmount(amount);
            accountRepository.save(accountEntity1);
            return accountEntityMapper.toAccount(accountEntity1);
        }

        return null;
    }
}
