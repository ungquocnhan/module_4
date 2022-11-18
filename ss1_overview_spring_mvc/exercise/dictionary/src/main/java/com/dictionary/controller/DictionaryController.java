package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @RequestMapping("")
    public String result(){
        return "dictionary";
    }

    @PostMapping("")
    public String result(@RequestParam String translate, Model model){
        String result = dictionaryService.result().get(translate);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
