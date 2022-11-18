package com.management_customer.repository;

import com.management_customer.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

}
