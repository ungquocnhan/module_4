package com.case_study.case_study_module_4.controller;

import com.case_study.case_study_module_4.model.facility.Facility;
import com.case_study.case_study_module_4.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityRestController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public ResponseEntity<List<Facility>> facilityList() {
        return new ResponseEntity<>(facilityService.findAll(), HttpStatus.OK);
    }
}
