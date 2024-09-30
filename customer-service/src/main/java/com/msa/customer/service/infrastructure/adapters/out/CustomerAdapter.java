package com.msa.customer.service.infrastructure.adapters.out;

import com.msa.customer.service.application.ports.out.CustomerOPort;
import com.msa.customer.service.domain.models.Customer;
import com.msa.customer.service.infrastructure.adapters.out.entities.CustomerEntity;
import com.msa.customer.service.infrastructure.adapters.out.mappers.CustomerEntityMapper;
import com.msa.customer.service.infrastructure.adapters.out.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerOPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        Customer customerSaved = customerEntityMapper.toCustomer(
                customerRepository.save(customerEntity)
        );
        return customerSaved;
    }
}
