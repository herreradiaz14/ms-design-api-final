package com.ms.account.middleend.client;

import com.ms.account.middleend.domain.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "account-service")
public interface AccountServiceClient {

    @PostMapping("api/v1/accounts")
    ResponseEntity<Account> createAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                          @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                          @RequestBody Account account);

    @GetMapping("api/v1/accounts/{id}")
    ResponseEntity<Account> getAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                       @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                       @RequestHeader(value = "id", required = true) Integer id);

    @GetMapping("api/v1/accounts/customer/{idCustomer}")
    ResponseEntity<List<Account>> getAccounts(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                              @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                              @RequestHeader(value = "idCustomer", required = true) Integer idCustomer);

    @PutMapping("api/v1/accounts/{id}")
    ResponseEntity<Account> updateAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                          @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                          @RequestHeader(value = "id", required = true) Integer id,
                                          @RequestBody Account account);
}
