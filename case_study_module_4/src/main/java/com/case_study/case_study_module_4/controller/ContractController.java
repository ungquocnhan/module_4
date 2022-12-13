package com.case_study.case_study_module_4.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    private final IContractService contractService;
    private final ICustomerService customerService;
    private final IFacilityService facilityService;
    private final IEmployeeService employeeService;

    public ContractController(IContractService contractService,
                              ICustomerService customerService,
                              IFacilityService facilityService,
                              IEmployeeService employeeService) {
        this.contractService = contractService;
        this.customerService = customerService;
        this.facilityService = facilityService;
        this.employeeService = employeeService;
    }


    @ModelAttribute("facilityList")
    public List<Facility> facilityList() {
        return facilityService.findAll();
    }

    @ModelAttribute("customerList")
    public List<Customer> customerList() {
        return customerService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> employeeList() {
        return employeeService.findAll();
    }

    @GetMapping("")
    public String showListContract(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<ContractView> contractViewPage = contractService.findAllContract(pageable);
        model.addAttribute("contractViewPage", contractViewPage);
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "contract/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Add success");
        return "redirect:/contract";
    }

}
