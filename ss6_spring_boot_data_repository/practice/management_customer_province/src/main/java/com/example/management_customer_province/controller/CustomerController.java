package com.example.management_customer_province.controller;

import com.example.management_customer_province.model.Customer;
import com.example.management_customer_province.model.Province;
import com.example.management_customer_province.service.ICustomerService;
import com.example.management_customer_province.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService;
    private final IProvinceService provinceService;
    @Autowired
    public CustomerController(ICustomerService customerService, IProvinceService provinceService) {
        this.customerService = customerService;
        this.provinceService = provinceService;
    }

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam("search") Optional<String> search, Pageable pageable, Model model) {
//        Iterable<Customer> customerList = customerService.findAll();
//        Page<Customer> customerList = customerService.findAll(pageable);
        Page<Customer> customerList;
        if(search.isPresent()){
            customerList = customerService.findAllByFirstNameContaining(search.get(), pageable);
        }else {
            customerList = customerService.findAll(pageable);
        }
        model.addAttribute("customerList", customerList);
        model.addAttribute("search", search);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "/customer/edit";
        } else {
            return "/error-404";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") int id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "/customer/delete";
        } else {
            return "/error-404";
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/customer";
    }
}
