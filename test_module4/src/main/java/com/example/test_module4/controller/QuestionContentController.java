package com.example.test_module4.controller;

import com.example.test_module4.dto.QuestionContentDto;
import com.example.test_module4.model.QuestionContent;
import com.example.test_module4.model.QuestionType;
import com.example.test_module4.service.IQuestionContentService;
import com.example.test_module4.service.IQuestionTypeService;
import com.example.test_module4.view.QuestionContentView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionContentController {
    @Autowired
    private IQuestionContentService questionContentService;

    @Autowired
    private IQuestionTypeService questionTypeService;

    @ModelAttribute("questionTypeList")
    public List<QuestionType> questionTypeList(){
        return questionTypeService.findAll();
    }

    @GetMapping("")
    public String showListQuestionContent(@RequestParam(defaultValue = "") String title,
                                          @RequestParam(defaultValue = "") String questionType,
                                          @PageableDefault(size = 5) Pageable pageable,
                                          Model model){
        Page<QuestionContentView> contentViewPage = questionContentService.search(title, questionType, pageable);
        model.addAttribute("contentViewPage", contentViewPage);
        model.addAttribute("title", title);
        model.addAttribute("questionType", questionType);
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        QuestionContentDto questionContentDto = new QuestionContentDto();
        model.addAttribute("questionContentDto", questionContentDto);
        return "create";
    }

    @PostMapping("/save")
    public String saveQuestionContent(@Validated @ModelAttribute("questionContentDto") QuestionContentDto questionContentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception{
        if(bindingResult.hasErrors()){
            return "create";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto, questionContent);
        questionContentService.save(questionContent);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/question";
    }

    @PostMapping("/delete")
    public String deleteQuestion(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes) throws Exception{
        questionContentService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/question";
    }

    @ExceptionHandler(Exception.class)
    public String showMessageError(){
        return "message";
    }
}
