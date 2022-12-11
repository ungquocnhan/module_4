package com.test.test.service;

import com.test.test.dto.CustomerView;
import com.test.test.model.Customer;
import com.test.test.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICustomerService {
    Optional<Customer> findById(int id);

    void save(Customer customer);

    void remove(int id);


    Page<CustomerView> showList(String name, String email, int customerTypeId, Pageable pageable);



}
