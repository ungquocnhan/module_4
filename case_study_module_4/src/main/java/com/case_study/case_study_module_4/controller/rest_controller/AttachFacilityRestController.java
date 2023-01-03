package com.case_study.case_study_module_4.controller.rest_controller;

import com.case_study.case_study_module_4.model.contract.AttachFacility;
import com.case_study.case_study_module_4.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attach-facilities")
public class AttachFacilityRestController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("")
    public ResponseEntity<List<AttachFacility>> listAttachFacility(){
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }
}
