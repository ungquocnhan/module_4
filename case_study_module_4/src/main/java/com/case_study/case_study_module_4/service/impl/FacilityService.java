package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.dto.FacilityView;
import com.case_study.case_study_module_4.model.facility.Facility;
import com.case_study.case_study_module_4.repository.IFacilityRepository;
import com.case_study.case_study_module_4.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public Page<FacilityView> findAllFacilityView(String name, String facilityType, Pageable pageable) {
        return facilityRepository.findAllFacilityView(name, facilityType, pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        facilityRepository.deleteById(id);
    }
}
