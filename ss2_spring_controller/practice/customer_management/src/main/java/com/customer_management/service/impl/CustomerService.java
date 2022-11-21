package com.customer_management.service.impl;


import com.customer_management.model.Customer;
import com.customer_management.repository.ICustomerRepository;
import com.customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer edit(Customer customer) {
        return customerRepository.edit(customer);
    }

//    @Override
//    public Customer save(Customer customer) {
//        return customerRepository.save(customer);
//    }

}
