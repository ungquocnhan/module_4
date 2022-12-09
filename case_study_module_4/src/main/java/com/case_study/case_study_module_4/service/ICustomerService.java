package com.case_study.case_study_module_4.service;

import com.case_study.case_study_module_4.dto.CustomerDto;
import com.case_study.case_study_module_4.dto.CustomerView;
import com.case_study.case_study_module_4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICustomerService extends IGenericService<Customer>{

    Page<CustomerView> findAllCustomerView(String name, String email, String customerType, Pageable pageable);
}
