package com.example.management_customer_province.controller;

import com.example.management_customer_province.model.Customer;
import com.example.management_customer_province.model.Province;
import com.example.management_customer_province.service.ICustomerService;
import com.example.management_customer_province.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProvinceController {
    private final IProvinceService provinceService;

    @Autowired
    public ProvinceController(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/province")
    public String showList(Model model){
        Iterable<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return "/province/list";
    }

    @GetMapping("/create-province")
    public String showCreateForm(Model model){
        Province province = new Province();
        model.addAttribute("province", province);
        return "/province/create";
    }

    @PostMapping("/save-province")
    public String update(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create Success");
        return "redirect:/province";
    }

    @GetMapping("/edit-province/{id}")
        public String showEditForm(@PathVariable("id") int id, Model model){
        Optional<Province> province = Optional.empty();
        try {
            province = provinceService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(province.isPresent()){
            model.addAttribute("province", province.get());
            return "/province/edit";
        }else {
            return "/error-404";
        }
    }

    @PostMapping("/update-province")
    public String save(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Edit Success");
        return "redirect:/province";
    }

    @GetMapping("/delete-province/{id}")
    public String showDelete(@PathVariable("id") int id, Model model){
        Optional<Province> province = Optional.empty();
        try {
            province = provinceService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(province.isPresent()){
            model.addAttribute("province", province);
            return "/province/delete";
        }else {
            return "/error-404";
        }
    }

    @PostMapping("/delete-province")
    public String delete(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.remove(province.getId());
        redirectAttributes.addFlashAttribute("message","Delete success");
        return "redirect:/province";
    }

    @GetMapping("/view-province/{id}")
    public String viewProvince(@PathVariable("id") int id, Model model){
        Optional<Province> province = Optional.empty();
        try {
            province = provinceService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!province.isPresent()){
            return "/error-404";
        }

        Iterable<Customer> customers = customerService.findAllByProvince(province.get());
        model.addAttribute("province", province.get());
        model.addAttribute("customers", customers);
        return "/province/view";
    }
}
