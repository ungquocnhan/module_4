package com.example.management_customer_province.service;

import com.example.management_customer_province.model.Customer;
import com.example.management_customer_province.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer>{
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);

}
