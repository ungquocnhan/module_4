package com.codegym.controller;

import com.codegym.model.EmailBox;
import com.codegym.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailBoxController {
    @Autowired
    private IEmailBoxService emailBoxService;

    @RequestMapping("")
    public String showList(Model model) {
        List<EmailBox> emailBoxList = emailBoxService.findAll();
        model.addAttribute("emailBoxList", emailBoxList);
        return "email_box/list";
    }

    @GetMapping("/updateForm")
    public String showEdit(@RequestParam("id") Integer id, Model model) {
        EmailBox emailBox = emailBoxService.findById(id);

        List<String> languagesList = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> pageSizeList = Arrays.asList(5, 10, 15, 25, 50, 100);

        model.addAttribute("emailBox", emailBox);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("pageSizeList", pageSizeList);

        return "email_box/edit";
    }

    @PostMapping("update")
    public String edit(EmailBox emailBox, RedirectAttributes redirectAttributes) {
        emailBoxService.update(emailBox);
        redirectAttributes.addFlashAttribute("message", "Edit Success");
        return "redirect:/email";
    }
}
