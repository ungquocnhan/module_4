package com.case_study.case_study_module_4.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T> {
    List<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);
}
