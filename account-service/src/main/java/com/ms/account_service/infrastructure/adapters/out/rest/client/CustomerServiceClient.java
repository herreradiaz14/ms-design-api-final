package com.ms.account_service.infrastructure.adapters.out.rest.client;

import com.ms.account_service.infrastructure.adapters.out.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "customer-service")
public interface CustomerServiceClient {
    @GetMapping("/api/v1/customers/{id}")
    ResponseEntity<Customer> getCustomer(
            @RequestHeader("x-sw-client-request-id") String xCmClientRequestId,
            @RequestHeader("x-sw-client-user-agent") String xCmClientUserAgent,
            @PathVariable("id") Integer id);
}