package com.case_study.case_study_module_4.repository;

import com.case_study.case_study_module_4.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
