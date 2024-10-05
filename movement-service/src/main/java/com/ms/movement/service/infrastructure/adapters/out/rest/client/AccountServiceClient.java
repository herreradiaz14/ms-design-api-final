package com.ms.movement.service.infrastructure.adapters.out.rest.client;

import com.ms.movement.service.infrastructure.adapters.out.entities.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "account-service")
public interface AccountServiceClient {

    @GetMapping("api/v1/accounts/{id}")
    ResponseEntity<Account> getAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                       @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                       @RequestHeader(value = "id", required = true) Integer id);

    @PutMapping("api/v1/accounts/{id}")
    ResponseEntity<Account> updateAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                          @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                          @RequestHeader(value = "id", required = true) Integer id,
                                          @RequestBody Account account);
}
