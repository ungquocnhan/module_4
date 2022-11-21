package com.calculator.controller;

import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("")
    public String display() {
        return "index";
    }

    @PostMapping("")
    public String showResult(@RequestParam("first_operand") double numberFirst,
                             @RequestParam("second_operand") double numberSecond,
                             @RequestParam("operator") String operator,
                             Model model) {
        double result;
        try {
            result = calculatorService.calculate(numberFirst, numberSecond, operator);
            model.addAttribute("result", result);
        } catch (ArithmeticException exception) {
            model.addAttribute("result", exception.getMessage());
        }
        return "index";
    }
}
