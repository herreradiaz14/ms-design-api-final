package com.msf.customer.middleend.service;
import com.msf.customer.middleend.domain.Customer;

public interface ICustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomer(Integer id);
}
