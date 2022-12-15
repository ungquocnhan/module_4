package com.case_study.case_study_module_4.service;

import com.case_study.case_study_module_4.dto.ContractDetailView;
import com.case_study.case_study_module_4.model.contract.ContractDetail;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailService extends IGenericService<ContractDetail>{
    List<ContractDetailView> showList(int contractId);

}
