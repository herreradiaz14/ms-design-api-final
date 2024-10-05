package com.ms.account.middleend.controller;

import com.ms.account.middleend.domain.Account;
import com.ms.account.middleend.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(iAccountService.getAccount(id), HttpStatus.OK);
    }

    @GetMapping("/customer/{idCustomer}")
    @CrossOrigin
    public ResponseEntity<List<Account>> getAccounts(@PathVariable Integer idCustomer){
        return new ResponseEntity<>(iAccountService.getAccounts(idCustomer), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account account){
        return new ResponseEntity<>(iAccountService.updateAccount(id, account), HttpStatus.OK);
    }
}
