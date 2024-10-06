package com.msf.customer.middleend.controller;
import com.msf.customer.middleend.domain.Customer;
import com.msf.customer.middleend.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService iCustomerService;

    @PostMapping()
    @CrossOrigin
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(iCustomerService.createCustomer(customer), HttpStatus.CREATED);
//        return new ResponseEntity<>(iCustomerService.createCustomer(customer), HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id){
        Customer customer = iCustomerService.getCustomer(id);
        if(Objects.isNull(customer)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
