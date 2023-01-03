package com.example.test.controller;

import com.example.test.model.so_ho_khau.HoKhau;
import com.example.test.service.IHoKhauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hokhau")
public class HoKhauController {
    @Autowired
    private IHoKhauService hoKhauService;

    @GetMapping("")
    public String listHoKhau(Model model){
        List<HoKhau> hoKhauList = hoKhauService.findAll();
        model.addAttribute("hoKhauList", hoKhauList);
        return "/list";
    }
}
