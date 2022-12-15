package com.case_study.case_study_module_4.repository;

import com.case_study.case_study_module_4.dto.ContractDetailView;
import com.case_study.case_study_module_4.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    @Query(value = "SELECT cd.id, cd.contract_id as contractId, af.name as attachFacilityName, cd.quantity FROM contract_detail cd JOIN attach_facility af on cd.attach_facility_id = af.id WHERE cd.contract_id = :id",nativeQuery = true)
    List<ContractDetailView> showList(@Param("id") int contractId);
}
