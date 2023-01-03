package com.case_study.case_study_module_4.controller.rest_controller;

import com.case_study.case_study_module_4.model.facility.FacilityType;
import com.case_study.case_study_module_4.service.impl.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facilityTypes")
@CrossOrigin("*")
public class FacilityTypeRestController {
    @Autowired
    private FacilityTypeService facilityTypeService;

    @GetMapping("")
    public ResponseEntity<List<FacilityType>> getAll() {
        return new ResponseEntity<>(facilityTypeService.findAll(), HttpStatus.OK);
    }
}
