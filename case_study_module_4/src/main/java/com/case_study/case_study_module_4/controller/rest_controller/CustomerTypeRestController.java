package com.case_study.case_study_module_4.controller.rest_controller;

import com.case_study.case_study_module_4.model.customer.CustomerType;
import com.case_study.case_study_module_4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customerTypes")
@CrossOrigin("*")
public class CustomerTypeRestController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ResponseEntity<List<CustomerType>> getAll(){
        return new ResponseEntity<>(customerTypeService.findAll(), HttpStatus.OK);
    }
}
