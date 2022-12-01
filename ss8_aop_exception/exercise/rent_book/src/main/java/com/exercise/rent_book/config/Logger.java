package com.exercise.rent_book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logger {
    @Pointcut(value = "execution(* com.exercise.rent_book.controller.BookController.*(..))")
    public void callMethod() {
    }

    @Before("callMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("Đang vào method " + joinPoint.getSignature().getName() + "vào thời gian: " + LocalDateTime.now());
    }

    @AfterThrowing(value = "execution(* com.exercise.rent_book.controller.BookController.*(..))")
    public void checkEx(){
        System.out.println("Gặp lỗi");
    }
}
