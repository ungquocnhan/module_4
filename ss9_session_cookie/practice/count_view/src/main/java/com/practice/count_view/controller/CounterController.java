package com.practice.count_view.controller;

import com.practice.count_view.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter setUpCounter(){
        return new Counter();
    }

    @RequestMapping("/")
    public String get(@ModelAttribute("counter") Counter counter){
        counter.increment();
        return "/index";
    }
}
