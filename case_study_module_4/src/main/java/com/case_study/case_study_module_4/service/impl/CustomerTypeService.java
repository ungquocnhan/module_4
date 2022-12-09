package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.model.customer.CustomerType;
import com.case_study.case_study_module_4.repository.ICustomerTypeRepository;
import com.case_study.case_study_module_4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

}
