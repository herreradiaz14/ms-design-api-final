package com.ms.account.middleend.controller;

import com.ms.account.middleend.domain.Account;
import com.ms.account.middleend.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService iAccountService;

    @PostMapping()
    @CrossOrigin
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(iAccountService.createAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Account> getAccount(@PathVariable Integer id){
        Account accountEn = iAccountService.getAccount(id);
        if(Objects.isNull(accountEn)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountEn, HttpStatus.OK);
    }

    @GetMapping("/customer/{idCustomer}")
    @CrossOrigin
    public ResponseEntity<List<Account>> getAccounts(@PathVariable Integer idCustomer){
        List<Account> accountList = iAccountService.getAccounts(idCustomer);
        if(CollectionUtils.isEmpty(accountList)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account account){
        Account accountEn = iAccountService.updateAccount(id, account);
        if(Objects.isNull(accountEn)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(accountEn, HttpStatus.OK);
    }
}
