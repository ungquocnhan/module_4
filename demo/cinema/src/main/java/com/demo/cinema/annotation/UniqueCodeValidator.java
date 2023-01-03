package com.demo.cinema.annotation;

import com.demo.cinema.repository.ISuatChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//@Component
//public class UniqueCodeValidator implements ConstraintValidator<UniqueCode, String> {
//
//    @Autowired
//    private ISuatChieuRepository suatChieuRepository;
//    @Override
//    public boolean isValid(String code, ConstraintValidatorContext context) {
//        return suatChieuRepository.findByCode(code) != null;
//    }
//}
