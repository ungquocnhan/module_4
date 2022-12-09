package com.case_study.case_study_module_4.service;

import com.case_study.case_study_module_4.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService{

    List<CustomerType> findAll();
}
