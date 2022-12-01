package com.exercise.rent_book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
        System.out.println("Đang vào method " + joinPoint.getSignature().getName() + " vào thời gian: " + LocalDateTime.now());
    }

    @AfterThrowing(value = "execution(* com.exercise.rent_book.controller.BookController.*(..))")
    public void checkEx(){
        System.out.println("Gặp lỗi");
    }

    @Pointcut(value = "execution(* com.exercise.rent_book.controller.BookController.rent(..))")
    public void rentMethod() {
    }

    @After("rentMethod()")
    public void afterRentMethod(JoinPoint joinPoint){
        System.out.println("Done " + joinPoint.getSignature().getName() + " vào thời gian: " + LocalDateTime.now());
    }

    @Pointcut(value = "execution(* com.exercise.rent_book.controller.BookController.payBook(..))")
    public void payMethod() {
    }

    @After("payMethod()")
    public void afterPayMethod(JoinPoint joinPoint){
        System.out.println("Done " + joinPoint.getSignature().getName() + " vào thời gian: " + LocalDateTime.now());
    }
}
