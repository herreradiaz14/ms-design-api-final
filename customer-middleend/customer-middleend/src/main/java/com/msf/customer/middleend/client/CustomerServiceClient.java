package com.msf.customer.middleend.client;
import com.msf.customer.middleend.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(url = "http://localhost:8090/api/v1", name = "customerServiceClient")
//Poner el nombre que muestra el Eureka
@FeignClient(name = "customer-service")
public interface CustomerServiceClient {
    @PostMapping("/api/v1/customers")
    ResponseEntity<Customer> createCustomer(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                          @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                          @RequestBody Customer customer);

    @GetMapping("/api/v1/customers/{id}")
    ResponseEntity<Customer> getCustomer(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                         @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                         @RequestHeader(value = "id", required = true) Integer id);
}
