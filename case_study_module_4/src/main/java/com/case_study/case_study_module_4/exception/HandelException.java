package com.case_study.case_study_module_4.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandelException {
    @ExceptionHandler(Exception.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("customer/create");
    }
}
