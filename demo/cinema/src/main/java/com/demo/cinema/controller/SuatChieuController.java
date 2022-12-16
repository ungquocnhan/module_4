package com.demo.cinema.controller;

import com.demo.cinema.dto.SuatChieuDto;
import com.demo.cinema.model.SuatChieu;
import com.demo.cinema.model.TenPhim;
import com.demo.cinema.service.ISuatChieuService;
import com.demo.cinema.service.ITenPhimService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cinema")
public class SuatChieuController {
    @Autowired
    private ISuatChieuService suatChieuService;

    @Autowired
    private ITenPhimService tenPhimService;

    @ModelAttribute("tenPhimList")
    public List<TenPhim> tenPhimList(){
        return tenPhimService.findAll();
    }

    @GetMapping("")
    public String showList(Model model){
        List<SuatChieu> suatChieuList = suatChieuService.showList();
        model.addAttribute("suatChieuList", suatChieuList);
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        SuatChieuDto suatChieuDto = new SuatChieuDto();
        model.addAttribute("suatChieuDto", suatChieuDto);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("suatChieuDto") SuatChieuDto suatChieuDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SuatChieuDto().validate(suatChieuDto, bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }
        SuatChieu suatChieu = new SuatChieu();
        BeanUtils.copyProperties(suatChieuDto, suatChieu);
        suatChieuService.save(suatChieu);
        redirectAttributes.addFlashAttribute("message", "Add success");
        return "redirect:/cinema";
    }

    @PostMapping("/delete")
    public String delete(@RequestAttribute("deleteId") int id, RedirectAttributes redirectAttributes){
        suatChieuService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/cinema";
    }
}
