package com.demo.cinema.controller;

import com.demo.cinema.dto.SuatChieuDto;
import com.demo.cinema.dto.SuatChieuView;
import com.demo.cinema.model.SuatChieu;
import com.demo.cinema.model.TenPhim;
import com.demo.cinema.service.ISuatChieuService;
import com.demo.cinema.service.ITenPhimService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String showList(@RequestParam(defaultValue = "") String ngayChieu,
                           @RequestParam(defaultValue = "") String tenPhim,
                           @RequestParam(defaultValue = "") String code,
                           @PageableDefault(size = 5) Pageable pageable, Model model){
//        List<SuatChieu> suatChieuList = suatChieuService.showList();
        Page<SuatChieuView> suatChieuList = suatChieuService.search(ngayChieu, tenPhim, code, pageable);
        model.addAttribute("suatChieuList", suatChieuList);
        model.addAttribute("ngayChieu", ngayChieu);
        model.addAttribute("tenPhim", tenPhim);
        model.addAttribute("code", code);

        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        SuatChieuDto suatChieuDto = new SuatChieuDto();
        model.addAttribute("suatChieuDto", suatChieuDto);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("suatChieuDto") SuatChieuDto suatChieuDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SuatChieuDto().validate(suatChieuDto, bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }
        SuatChieu suatChieu = new SuatChieu();
        BeanUtils.copyProperties(suatChieuDto, suatChieu);
        try {
            suatChieuService.save(suatChieu);
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("message", "Ma suat chieu duplicate. Please re-input!!!!!");
            return "redirect:/cinema/create";
        }
//        suatChieuService.save(suatChieu);
        redirectAttributes.addFlashAttribute("message", "Add success");
        return "redirect:/cinema";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes){
        suatChieuService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/cinema";
    }

}
