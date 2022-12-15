package com.case_study.case_study_module_4.repository;

import com.case_study.case_study_module_4.dto.ContractView;
import com.case_study.case_study_module_4.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    
    @Query(value = "SELECT ctr.id, f.name as facilityName, c.name as customerName, ctr.deposit, ctr.date_start as dateStart, ctr.date_end as dateEnd, SUM((ifnull(cd.quantity,0) * ifnull(af.cost,0)) + ifnull(f.cost,0)) as sumMoney FROM contract ctr" +
            "            LEFT JOIN customer c ON c.id = ctr.customer_id" +
            "            LEFT JOIN facility f ON f.id = ctr.facility_id" +
            "            LEFT JOIN contract_detail cd ON ctr.id = cd.contract_id" +
            "            LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id" +
            "            GROUP BY ctr.id",
    countQuery = "select * from (SELECT ctr.id, f.name as facilityName, c.name as customerName, ctr.deposit, ctr.date_start as dateStart, ctr.date_end as dateEnd, SUM((ifnull(cd.quantity,0) * ifnull(af.cost,0)) + ifnull(f.cost,0)) as sumMoney FROM contract ctr" +
            "            LEFT JOIN customer c ON c.id = ctr.customer_id" +
            "            LEFT JOIN facility f ON f.id = ctr.facility_id" +
            "            LEFT JOIN contract_detail cd ON ctr.id = cd.contract_id" +
            "            LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id" +
            "            GROUP BY ctr.id) as count_contract",
    nativeQuery = true)
    Page<ContractView> findAllContract(Pageable pageable);

    @Query(value = "SELECT ctr.id, f.name as facilityName, c.name as customerName, ctr.deposit, ctr.date_start as dateStart, ctr.date_end as dateEnd, SUM((ifnull(cd.quantity,0) * ifnull(af.cost,0)) + ifnull(f.cost,0)) as sumMoney FROM contract ctr" +
            "            LEFT JOIN customer c ON c.id = ctr.customer_id" +
            "            LEFT JOIN facility f ON f.id = ctr.facility_id" +
            "            LEFT JOIN contract_detail cd ON ctr.id = cd.contract_id" +
            "            LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id" +
            "            WHERE ctr.customer_id = :customerId" +
            "            GROUP BY ctr.id",
            nativeQuery = true)
    List<ContractView> findAllContractCustomerUseFacility(@Param("customerId") int customerId);
}
