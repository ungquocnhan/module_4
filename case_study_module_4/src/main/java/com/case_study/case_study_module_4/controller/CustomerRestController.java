package com.case_study.case_study_module_4.controller;

import com.case_study.case_study_module_4.model.customer.Customer;
import com.case_study.case_study_module_4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> customerList() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK) ;
    }
}
