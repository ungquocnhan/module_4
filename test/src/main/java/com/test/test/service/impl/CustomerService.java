package com.test.test.service.impl;

import com.test.test.dto.CustomerView;
import com.test.test.model.Customer;
import com.test.test.model.CustomerType;
import com.test.test.repository.ICustomerRepository;
import com.test.test.repository.ICustomerTypeRepository;
import com.test.test.service.ICustomerService;
import com.test.test.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICustomerTypeService customerTypeService;
    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }

        @Override
    public Page<CustomerView> showList(String name, String email, int customerTypeId, Pageable pageable) {
        if (customerTypeId == -1 || customerTypeService.findById(customerTypeId).isPresent()) {
            return customerRepository.findByNameContainingAndEmailContaining(name, email, pageable);
        }
        return customerRepository.findByNameContainingAndEmailContainingAndCustomerType(name, email, customerTypeService.findById(customerTypeId).get(), pageable);
    }

}
