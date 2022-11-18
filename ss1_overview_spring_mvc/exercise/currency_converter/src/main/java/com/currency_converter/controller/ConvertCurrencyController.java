package com.currency_converter.controller;

import com.currency_converter.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/convert")
public class ConvertCurrencyController {
    @Autowired
    private IConvertService convertService;

    @GetMapping("")
    public String convertCurrency() {
        return "convert";
    }

    @PostMapping("")
    public String convertToVnd(@RequestParam double usd, Model model) {
        double vnd = convertService.convertToVnd(usd);
        model.addAttribute("vnd", vnd);
        return "convert";
    }

}
