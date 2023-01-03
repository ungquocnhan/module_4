package com.case_study.case_study_module_4.controller.rest_controller;

import com.case_study.case_study_module_4.model.customer.Customer;
import com.case_study.case_study_module_4.model.facility.Facility;
import com.case_study.case_study_module_4.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facilities")
@CrossOrigin("*")
public class FacilityRestController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public ResponseEntity<List<Facility>> getAll() {
        return new ResponseEntity<>(facilityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Facility> save(@RequestBody Facility facility) {
        facilityService.save(facility);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facility> findById(@PathVariable("id") int id) {
        Optional<Facility> facilityOptional = facilityService.findById(id);
        if (!facilityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facilityOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facility> edit(@PathVariable("id") int id, @RequestBody Facility facility) {
        Optional<Facility> facilityOptional = facilityService.findById(id);
        if (!facilityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        facility.setId(facilityOptional.get().getId());
        facilityService.save(facility);
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Facility> detete(@PathVariable("id") int id) {
        Optional<Facility> facility = facilityService.findById(id);
        if (!facility.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        facilityService.remove(facility.get().getId());
        return new ResponseEntity<>(facility.get(), HttpStatus.OK);
    }
}
