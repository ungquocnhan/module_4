package com.case_study.case_study_module_4.dto;

import com.case_study.case_study_module_4.model.customer.CustomerType;

public interface CustomerView {
    int getId();

    String getName();

    String getBirthday();

    boolean isGender();

    String getIdCard();

    String getPhoneNumber();

    String getEmail();

    String getAddress();

    CustomerType getCustomerType();

    String getTypeName();
}
