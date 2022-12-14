package com.case_study.case_study_module_4.controller;

import com.case_study.case_study_module_4.model.employee.Employee;
import com.case_study.case_study_module_4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> employeeList() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK) ;
    }
}
