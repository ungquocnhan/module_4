package com.customer_management.service;

import com.customer_management.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer edit(Customer customer);


//    Customer save(Customer customer);

}
