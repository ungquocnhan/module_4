package com.case_study.case_study_module_4.dto;

import com.case_study.case_study_module_4.model.facility.FacilityType;
import com.case_study.case_study_module_4.model.facility.RentType;


public interface FacilityView {
    int getId();

    String getName();

    int getArea();

    double getCost();

    int getMaxPeople();

    String getStandardRoom();

    String getDescriptionOtherConvenience();

    double getPoolArea();

    int getNumberOfFloor();

    String getFacilityFree();

    RentType getRentType();

    FacilityType getFacilityType();

    String getRentTypeName();

    String getFacilityTypeName();

}
