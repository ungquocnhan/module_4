package com.case_study.case_study_module_4.repository;

import com.case_study.case_study_module_4.dto.FacilityView;
import com.case_study.case_study_module_4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select f.id, f.area, f.cost, f.description_other_convenience as descriptionOtherConvenience, f.facility_free as facilityFree, f.max_people as maxPeople, f.name, f.number_of_floor as numberOfFloor, f.pool_area as poolArea, f.standard_room as standardRoom, ft.name as facilityTypeName, rt.name as rentTypeName from facility f join facility_type ft on f.facility_type_id = ft.id join rent_type rt on f.rent_type_id = rt.id where f.flag = 1 and f.name like concat('%', :name, '%') and ft.name like concat('%', :facilityType, '%')",
            countQuery = "select * from (select f.id, f.area, f.cost, f.description_other_convenience as descriptionOtherConvenience, f.facility_free as facilityFree, f.max_people as maxPeople, f.name, f.number_of_floor as numberOfFloor, f.pool_area as poolArea, f.standard_room as standardRoom, ft.name as facilityTypeName, rt.name as rentTypeName from facility f join facility_type ft on f.facility_type_id = ft.id join rent_type rt on f.rent_type_id = rt.id where f.flag = 1 and f.name like concat('%', :name, '%') and ft.name like concat('%', :facilityType, '%')) as facility_count",
            nativeQuery = true)
    Page<FacilityView> findAllFacilityView(@Param("name") String name, @Param("facilityType") String facilityType, Pageable pageable);
}
