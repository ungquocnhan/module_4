package com.example.management_customer_province.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id) throws Exception;

    void save(T t);

    void remove(Integer id);
}
