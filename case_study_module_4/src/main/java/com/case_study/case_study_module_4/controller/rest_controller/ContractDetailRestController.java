package com.case_study.case_study_module_4.controller.rest_controller;

import com.case_study.case_study_module_4.dto.ContractDetailView;
import com.case_study.case_study_module_4.model.contract.Contract;
import com.case_study.case_study_module_4.model.contract.ContractDetail;
import com.case_study.case_study_module_4.service.IContractDetailService;
import com.case_study.case_study_module_4.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contract-details")
public class ContractDetailRestController {
    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public ResponseEntity<List<ContractDetail>> listContractDetail(){
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<ContractDetailView>> showList(@PathVariable("id") int contractId) {
        List<ContractDetailView> contractDetailViewList = contractDetailService.showList(contractId);
        return new ResponseEntity<>(contractDetailViewList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ContractDetail> save(@RequestBody ContractDetail contractDetail){
        Optional<Contract> contract = contractService.findById(contractDetail.getContract().getId());
        contractDetail.setContract(contract.get());
        contractDetailService.save(contractDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
