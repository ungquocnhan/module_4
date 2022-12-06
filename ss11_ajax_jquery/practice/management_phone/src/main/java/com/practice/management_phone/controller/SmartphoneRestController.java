package com.practice.management_phone.controller;

import com.practice.management_phone.model.Smartphone;
import com.practice.management_phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneRestController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping("")
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone){
        Smartphone smartphoneCreate = smartphoneService.save(smartphone);
        return new ResponseEntity<>(smartphoneCreate, HttpStatus.CREATED);
    }

//    @GetMapping("/list")
//    public String getAllSmartphonePage(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model){
//        Page<Smartphone> smartphones = smartphoneService.findAllFlag(pageable);
//        model.addAttribute("smartphones", smartphones);
//        return "/phones/list";
//    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAllFlag(pageable));
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable("id") int id){
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.updateFlag(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

}
