package com.exercise.validation_form_register.controller;

import com.exercise.validation_form_register.dto.UserDto;
import com.exercise.validation_form_register.handle.DuplicateEmailException;
import com.exercise.validation_form_register.model.User;
import com.exercise.validation_form_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public String showForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) throws DuplicateEmailException {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            return "/result";
        }
    }

//    @PostMapping("/save")
//    public String save(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "create";
//        } else {
//            User user = new User();
//            BeanUtils.copyProperties(userDto, user);
//            try {
//                userService.save(user);
//            } catch (DuplicateEmailException e) {
//                return "/inputs-not-acceptable";
//            }
//            return "/result";
//        }
//    }

    @ExceptionHandler(DuplicateEmailException.class)
    public String showInputNotAcceptable() {
        return "/inputs-not-acceptable";
    }
}
