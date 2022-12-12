package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.model.facility.RentType;
import com.case_study.case_study_module_4.repository.IRentTypeRepository;
import com.case_study.case_study_module_4.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
