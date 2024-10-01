package com.msa.customer.service.infrastructure.adapters.out;

import com.ms.customer.service.server.models.CustomerDto;
import com.msa.customer.service.application.ports.out.CustomerOPort;
import com.msa.customer.service.domain.models.Customer;
import com.msa.customer.service.infrastructure.adapters.out.entities.CustomerEntity;
import com.msa.customer.service.infrastructure.adapters.out.mappers.CustomerEntityMapper;
import com.msa.customer.service.infrastructure.adapters.out.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerOPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        return customerEntityMapper.toCustomer(
                customerRepository.save(customerEntity)
        );
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        Optional<CustomerEntity> customerFind = customerRepository.findById(customerId);

        return customerFind.map(customerEntityMapper::toCustomer).orElse(null);

    }
}
