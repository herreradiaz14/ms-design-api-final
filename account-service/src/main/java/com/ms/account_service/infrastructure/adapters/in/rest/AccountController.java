package com.ms.account_service.infrastructure.adapters.in.rest;

import com.ms.account.service.server.AccountsApi;
import com.ms.account.service.server.models.AccountDto;
import com.ms.account.service.server.models.AccountsDtoInner;
import com.ms.account_service.application.ports.in.AccountIPort;
import com.ms.account_service.domain.models.Account;
import com.ms.account_service.infrastructure.adapters.in.rest.mappers.AccountDtoMapper;
import com.ms.account_service.infrastructure.adapters.out.entities.Customer;
import com.ms.account_service.infrastructure.adapters.out.rest.client.CustomerServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AccountController implements AccountsApi {

    private final AccountIPort accountIPort;
    private final AccountDtoMapper accountDtoMapper;
    private final CustomerServiceClient customerServiceClient;

    @Override
    public ResponseEntity<AccountDto> createAccount(String xCmClientRequestId, String xCmClientUserAgent, AccountDto accountDto) {

        Account account = accountDtoMapper.toAccount(accountDto);
        Integer customerId = account.getCustomerId();
        ResponseEntity<Customer> customerResponse = customerServiceClient.getCustomer(xCmClientRequestId, xCmClientUserAgent, customerId);
        if (customerResponse.getStatusCode() != HttpStatus.OK || customerResponse.getBody() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AccountDto accountSavedDto = accountDtoMapper.toAccountDto(
                accountIPort.createAccount(account)
        );

        return new ResponseEntity<>(accountSavedDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AccountDto> getAccount(String xCmClientRequestId, String xCmClientUserAgent, Integer id){
        Account accountFind = accountIPort.getAccount(id);

        if(Objects.isNull(accountFind)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AccountDto accountDtoGet = accountDtoMapper.toAccountDto(accountFind);
        return new ResponseEntity<>(accountDtoGet, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AccountsDtoInner>> getAccounts(String xCmClientRequestId, String xCmClientUserAgent, Integer idCustomer){
        List<Account> accountList = accountIPort.getAccounts(idCustomer);
        if(Objects.isNull(accountList)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<AccountsDtoInner> accountDtoGet = accountDtoMapper.toAccountListDto(accountList);
        return new ResponseEntity<>(accountDtoGet, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AccountDto> updateAccount(String xCmClientRequestId, String xCmClientUserAgent, Integer id, AccountDto accountDto) {
        Account account = accountDtoMapper.toAccount(accountDto);
        Account accountUpd = accountIPort.updateAccount(id, account);

        if(Objects.isNull(accountUpd)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AccountDto accountDtoGet = accountDtoMapper.toAccountDto(accountUpd);
        return new ResponseEntity<>(accountDtoGet, HttpStatus.OK);
    }
}
