package com.case_study.case_study_module_4.controller.rest_controller;

import com.case_study.case_study_module_4.model.facility.RentType;
import com.case_study.case_study_module_4.service.impl.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rentTypes")
@CrossOrigin("*")
public class RentTypeRestController {
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("")
    public ResponseEntity<List<RentType>> getAll() {
        return new ResponseEntity<>(rentTypeService.findAll(), HttpStatus.OK);
    }
}
