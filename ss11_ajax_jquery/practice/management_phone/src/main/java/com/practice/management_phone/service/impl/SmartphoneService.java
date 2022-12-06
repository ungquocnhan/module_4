package com.practice.management_phone.service.impl;

import com.practice.management_phone.model.Smartphone;
import com.practice.management_phone.repository.ISmartphoneRepository;
import com.practice.management_phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {

    private final ISmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneService(ISmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @Override
    public Page<Smartphone> findAllFlag(Pageable pageable) {
        return smartphoneRepository.findAllFlag(pageable);
    }

    @Override
    public void updateFlag(int id) {
        smartphoneRepository.updateFlag(id);
    }

    @Override
    public Optional<Smartphone> findById(int id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }
}
