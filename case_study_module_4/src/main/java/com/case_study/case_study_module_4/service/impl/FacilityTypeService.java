package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.model.facility.FacilityType;
import com.case_study.case_study_module_4.repository.IFacilityTypeRepository;
import com.case_study.case_study_module_4.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
