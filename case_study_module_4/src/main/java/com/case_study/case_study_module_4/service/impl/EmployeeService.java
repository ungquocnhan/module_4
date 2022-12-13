package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.model.employee.Employee;
import com.case_study.case_study_module_4.repository.IEmployeeRepository;
import com.case_study.case_study_module_4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void remove(int id) {

    }
}
