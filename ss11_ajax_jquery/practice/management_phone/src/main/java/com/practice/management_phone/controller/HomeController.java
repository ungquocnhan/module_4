package com.practice.management_phone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.GeneratedValue;

@Controller
public class HomeController {

    @GetMapping("")
    public String showIndex(){
        return "/index";
    }
}
