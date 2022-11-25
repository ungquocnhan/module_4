package com.example.management_customer_province.controller;

import com.example.management_customer_province.model.Province;
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

    @GetMapping("/province")
    public String showList(Model model){
        Iterable<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return "/province/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        Province province = new Province();
        model.addAttribute("province", province);
        return "/province/create";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Create Success");
        return "redirect:/province";
    }

    @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable("id") int id, Model model){
        Optional<Province> province = provinceService.findById(id);
        if(province.isPresent()){
            model.addAttribute("province", province.get());
            return "/province/edit";
        }else {
            return "/province/error-404";
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Edit Success");
        return "redirect:/province";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") int id, Model model){
        Optional<Province> province = provinceService.findById(id);
        if(province.isPresent()){
            model.addAttribute("province", province);
            return "/province/delete";
        }else {
            return "/province/error-404";
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        provinceService.remove(province.getId());
        redirectAttributes.addFlashAttribute("message","Delete success");
        return "redirect:/province";
    }

}
