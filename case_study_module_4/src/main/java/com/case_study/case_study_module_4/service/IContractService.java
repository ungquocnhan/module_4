package com.case_study.case_study_module_4.service;

import com.case_study.case_study_module_4.dto.ContractView;
import com.case_study.case_study_module_4.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService extends IGenericService<Contract>{

    Page<ContractView> findAllContract(Pageable pageable);

}
