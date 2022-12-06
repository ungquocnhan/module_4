package com.practice.management_phone.service;

import com.practice.management_phone.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ISmartphoneService {
    Page<Smartphone> findAllFlag(Pageable pageable);

    void updateFlag(int id);

    Optional<Smartphone> findById(int id);

    Smartphone save(Smartphone smartphone);
}
