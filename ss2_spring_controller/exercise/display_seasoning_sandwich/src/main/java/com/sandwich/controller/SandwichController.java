package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    @RequestMapping("")
    public String showDisplay(){
        return "index";
    }

    @PostMapping("")
    public String result(@RequestParam("condiment") String[] condiment, Model model){
        String result = Arrays.toString(condiment);
        model.addAttribute("result", result);
        return "index";
    }
}
