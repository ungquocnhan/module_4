package com.case_study.case_study_module_4.repository;

import com.case_study.case_study_module_4.dto.FacilityView;
import com.case_study.case_study_module_4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select f.id, f.area, f.cost, f.description_other_convenience, f.facility_free, f.max_people, f.name, f.number_of_floor, f.pool_area, f.standard_room, ft.name as facilityTypeName, rt.name as rentTypeName from facility f join facility_type ft on f.facility_type_id = ft.id join rent_type rt on f.rent_type_id = rt.id where f.name like concat('%', :name, '%') and ft.name like concat('%', :facilityType, '%')",
            countQuery = "select * from (select f.id, f.area, f.cost, f.description_other_convenience, f.facility_free, f.max_people, f.name, f.number_of_floor, f.pool_area, f.standard_room, ft.name as facilityTypeName, rt.name as rentTypeName from facility f join facility_type ft on f.facility_type_id = ft.id join rent_type rt on f.rent_type_id = rt.id where f.name like concat('%', :name, '%') and ft.name like concat('%', :facilityType, '%')) as facility_count",
            nativeQuery = true)
    Page<FacilityView> findAllFacilityView(@Param("name") String name, @Param("facilityType") String facilityType, Pageable pageable);
}
