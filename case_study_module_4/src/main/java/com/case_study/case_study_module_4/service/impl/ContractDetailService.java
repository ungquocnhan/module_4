package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.model.contract.ContractDetail;
import com.case_study.case_study_module_4.repository.IContractDetailRepository;
import com.case_study.case_study_module_4.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return null;
    }

    @Override
    public Optional<ContractDetail> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(int id) {

    }
}
