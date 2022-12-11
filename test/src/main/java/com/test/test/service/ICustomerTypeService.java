package com.test.test.service;

import com.test.test.model.CustomerType;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService {

    List<CustomerType> findAll();

    Optional<CustomerType> findById(int id);

}
