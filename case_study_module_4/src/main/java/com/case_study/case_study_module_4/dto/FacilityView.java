package com.case_study.case_study_module_4.dto;

import com.case_study.case_study_module_4.model.facility.FacilityType;
import com.case_study.case_study_module_4.model.facility.RentType;


public interface FacilityView {
    int getId();

    String getName();

    Integer getArea();

    Double getCost();

    Integer getMaxPeople();

    String getStandardRoom();

    String getDescriptionOtherConvenience();

    Double getPoolArea();

    Integer getNumberOfFloor();

    String getFacilityFree();

    RentType getRentType();

    FacilityType getFacilityType();

    String getRentTypeName();

    String getFacilityTypeName();

}
