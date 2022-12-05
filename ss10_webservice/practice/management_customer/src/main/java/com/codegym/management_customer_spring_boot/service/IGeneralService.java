package com.codegym.management_customer_spring_boot.service;

import com.codegym.management_customer_spring_boot.model.Customer;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    Customer save(T t);

    void remove(Integer id);
}
