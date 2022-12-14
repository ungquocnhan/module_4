package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.model.contract.AttachFacility;
import com.case_study.case_study_module_4.repository.IAttachFacilityRepository;
import com.case_study.case_study_module_4.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public Optional<AttachFacility> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(AttachFacility attachFacility) {

    }

    @Override
    public void remove(int id) {

    }
}
