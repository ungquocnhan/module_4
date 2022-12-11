package com.case_study.case_study_module_4.controller;

import com.case_study.case_study_module_4.dto.FacilityView;
import com.case_study.case_study_module_4.model.facility.FacilityType;
import com.case_study.case_study_module_4.service.IFacilityService;
import com.case_study.case_study_module_4.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    private final IFacilityService facilityService;
    private IFacilityTypeService facilityTypeService;

    @Autowired
    public FacilityController(IFacilityService facilityService, IFacilityTypeService facilityTypeService) {
        this.facilityService = facilityService;
        this.facilityTypeService = facilityTypeService;
    }

    @ModelAttribute("facilityTypeList")
    public List<FacilityType> facilityTypeList(){
        return facilityTypeService.findAll();
    }

    @GetMapping("")
    public String showListFacility(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String facilityType, @PageableDefault(size = 5)Pageable pageable, Model model){
        Page<FacilityView> facilityViewPage = facilityService.findAllFacilityView(name, facilityType, pageable);
        model.addAttribute("facilityViewPage", facilityViewPage);
        return "/facility/list";
    }
}
