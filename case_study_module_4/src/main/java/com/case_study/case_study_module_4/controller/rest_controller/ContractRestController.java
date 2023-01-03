package com.case_study.case_study_module_4.controller.rest_controller;

import com.case_study.case_study_module_4.dto.ContractView;
import com.case_study.case_study_module_4.model.contract.Contract;
import com.case_study.case_study_module_4.model.customer.Customer;
import com.case_study.case_study_module_4.model.employee.Employee;
import com.case_study.case_study_module_4.model.facility.Facility;
import com.case_study.case_study_module_4.service.IContractService;
import com.case_study.case_study_module_4.service.ICustomerService;
import com.case_study.case_study_module_4.service.IEmployeeService;
import com.case_study.case_study_module_4.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/contracts")
@CrossOrigin("*")
public class ContractRestController {
    private final IContractService contractService;

    public ContractRestController(IContractService contractService) {
        this.contractService = contractService;
    }

//    @GetMapping("")
//    public ResponseEntity<Page<ContractView>> getListContract(@PageableDefault(size = 5) Pageable pageable){
//        Page<ContractView> contractViewPage = contractService.findAllContract(pageable);
//        return new ResponseEntity<>(contractViewPage, HttpStatus.OK);
//    }

    @PostMapping("")
    public ResponseEntity<Contract> save(@RequestBody Contract contract){
        contractService.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<ContractView>> getContractByCustomer(@PathVariable("id") int customerId){
        List<ContractView> contractViewList = contractService.findAllContractCustomerUseFacility(customerId);
        return new ResponseEntity<>(contractViewList, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Contract>> getAll() {
        return new ResponseEntity<>(contractService.findAll(), HttpStatus.OK);
    }
}
