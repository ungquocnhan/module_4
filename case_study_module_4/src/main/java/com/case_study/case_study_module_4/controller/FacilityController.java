package com.case_study.case_study_module_4.controller;

import com.case_study.case_study_module_4.dto.FacilityDto;
import com.case_study.case_study_module_4.dto.FacilityView;
import com.case_study.case_study_module_4.model.facility.Facility;
import com.case_study.case_study_module_4.model.facility.FacilityType;
import com.case_study.case_study_module_4.model.facility.RentType;
import com.case_study.case_study_module_4.service.IFacilityService;
import com.case_study.case_study_module_4.service.IFacilityTypeService;
import com.case_study.case_study_module_4.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    private final IFacilityService facilityService;
    private final IFacilityTypeService facilityTypeService;
    private final IRentTypeService rentTypeService;

    @Autowired
    public FacilityController(IFacilityService facilityService, IFacilityTypeService facilityTypeService, IRentTypeService rentTypeService) {
        this.facilityService = facilityService;
        this.facilityTypeService = facilityTypeService;
        this.rentTypeService = rentTypeService;
    }

    @ModelAttribute("facilityTypeList")
    public List<FacilityType> facilityTypeList(){
        return facilityTypeService.findAll();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> rentTypeList(){
        return rentTypeService.findAll();
    }

    @GetMapping("")
    public String showListFacility(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String facilityTypeName, @PageableDefault(size = 5)Pageable pageable, Model model){
        Page<FacilityView> facilityViewPage = facilityService.findAllFacilityView(name, facilityTypeName, pageable);
        model.addAttribute("facilityViewPage", facilityViewPage);
        model.addAttribute("name", name);
        model.addAttribute("facilityTypeName", facilityTypeName);

        return "facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        FacilityDto facilityDto = new FacilityDto();
        model.addAttribute("facilityDto", facilityDto);
        return "facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("facilityDto") FacilityDto facilityDto, RedirectAttributes redirectAttributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Add success");
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model){
        Optional<Facility> facility = facilityService.findById(id);
        if(!facility.isPresent()){
            return "/error";
        }
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility.get(), facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        int facilityTypeId = facility.get().getFacilityType().getId();
        model.addAttribute("facilityTypeId", facilityTypeId);
        return "facility/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("facilityDto") FacilityDto facilityDto, RedirectAttributes redirectAttributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes){
        facilityService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/facility";
    }
}
