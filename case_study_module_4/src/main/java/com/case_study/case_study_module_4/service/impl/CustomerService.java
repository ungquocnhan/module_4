package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.dto.CustomerUseFacility;
import com.case_study.case_study_module_4.dto.CustomerView;
import com.case_study.case_study_module_4.model.customer.Customer;
import com.case_study.case_study_module_4.repository.ICustomerRepository;
import com.case_study.case_study_module_4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<CustomerView> findAllCustomerView(String name, String email, String customerType, Pageable pageable) {
        return customerRepository.findAllCustomerView(name, email, customerType, pageable);
    }

    @Override
    public Page<CustomerUseFacility> showList(Pageable pageable) {
        return customerRepository.showList(pageable);
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

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
}
