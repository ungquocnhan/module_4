package com.exercise.validation_form_register.controller;

import com.exercise.validation_form_register.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String showForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "/list";
    }

    @PostMapping("/validate-user")
    public String validateUser(@Validated @ModelAttribute("user") UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/list";
        } else {
            return "/result";
        }
    }
}
