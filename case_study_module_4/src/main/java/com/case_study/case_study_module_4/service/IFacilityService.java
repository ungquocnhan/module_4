package com.case_study.case_study_module_4.service;

import com.case_study.case_study_module_4.dto.FacilityView;
import com.case_study.case_study_module_4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IFacilityService extends IGenericService<Facility>{
    Page<FacilityView> findAllFacilityView(String name, String facilityType, Pageable pageable);

}
