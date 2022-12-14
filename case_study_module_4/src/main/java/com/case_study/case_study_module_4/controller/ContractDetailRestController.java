package com.case_study.case_study_module_4.controller;

import com.case_study.case_study_module_4.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract-details")
public class ContractDetailRestController {
    @Autowired
    private IContractDetailService contractDetailService;
}
