package com.customer_management.repository;

import com.customer_management.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer edit(Customer customer);

//    Customer save(Customer customer);
}
