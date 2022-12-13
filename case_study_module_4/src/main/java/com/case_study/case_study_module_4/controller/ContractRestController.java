package com.case_study.case_study_module_4.controller;

import com.case_study.case_study_module_4.dto.ContractView;
import com.case_study.case_study_module_4.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/contracts")
@CrossOrigin("*")
public class ContractRestController {
    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public ModelAndView showListContract(@PageableDefault(size = 5)Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("contract/rest_list");
        Page<ContractView> contractViewPage = contractService.findAllContract(pageable);
        modelAndView.addObject("contractViewPage", contractViewPage);
        return modelAndView;
    }
}
