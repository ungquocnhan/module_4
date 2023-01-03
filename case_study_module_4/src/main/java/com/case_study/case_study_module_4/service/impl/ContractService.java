package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.dto.ContractView;
import com.case_study.case_study_module_4.model.contract.Contract;
import com.case_study.case_study_module_4.repository.IContractRepository;
import com.case_study.case_study_module_4.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<ContractView> findAllContract(Pageable pageable) {
        return contractRepository.findAllContract(pageable);
    }

    @Override
    public List<ContractView> findAllContractCustomerUseFacility(int customerId) {
        return contractRepository.findAllContractCustomerUseFacility(customerId);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(int id) {

    }
}
