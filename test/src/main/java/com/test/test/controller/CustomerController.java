package com.test.test.controller;

import com.test.test.dto.CustomerView;
import com.test.test.model.CustomerType;
import com.test.test.service.ICustomerService;
import com.test.test.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService customerService;
    private final ICustomerTypeService customerTypeService;

    @Autowired
    public CustomerController(ICustomerService customerService, ICustomerTypeService customerTypeService) {
        this.customerService = customerService;
        this.customerTypeService = customerTypeService;
    }

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList(){
        return customerTypeService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "-1") int customerTypeId, @PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<CustomerView> customerViewPage = customerService.showList(name, email, customerTypeId, pageable);
        model.addAttribute("customerViewPage", customerViewPage);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeId", customerTypeId);
        return "customer/list";
    }
}