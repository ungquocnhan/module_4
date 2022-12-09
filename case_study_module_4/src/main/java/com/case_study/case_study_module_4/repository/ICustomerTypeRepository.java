package com.case_study.case_study_module_4.repository;

import com.case_study.case_study_module_4.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
