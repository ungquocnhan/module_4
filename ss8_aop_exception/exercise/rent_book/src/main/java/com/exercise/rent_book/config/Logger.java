package com.exercise.rent_book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logger {
    public static final String GHI_LOG = "F:/CODEGYM/module_4/ss8_aop_exception/exercise/rent_book/src/main/java/com/exercise/rent_book/config/ghi_log_count.txt";
    public static final String GHI_LOG_RENT = "F:/CODEGYM/module_4/ss8_aop_exception/exercise/rent_book/src/main/java/com/exercise/rent_book/config/ghi_log_rent.txt";
    public static final String GHI_LOG_PAY = "F:/CODEGYM/module_4/ss8_aop_exception/exercise/rent_book/src/main/java/com/exercise/rent_book/config/ghi_log_pay.txt";
    public static final String GHI_LOG_EX = "F:/CODEGYM/module_4/ss8_aop_exception/exercise/rent_book/src/main/java/com/exercise/rent_book/config/ghi_log_exception.txt";

    static private int number = 0;

    @AfterThrowing(value = "execution(* com.exercise.rent_book.controller.BookController.*(..))")
    public void checkEx() {
        WriteFile.writeFileException("Gặp lỗi");
        System.out.println("Gặp lỗi");
    }

    @Pointcut(value = "execution(* com.exercise.rent_book.controller.BookController.rent(..))")
    public void rentMethod() {
    }

    @AfterReturning("rentMethod()")
    public void afterRentMethod(JoinPoint joinPoint) {
        WriteFile.writeFileRent("Mượn sách thành công " + "vào thời gian: " + LocalDateTime.now());
        System.out.println("Done " + joinPoint.getSignature().getName() + " vào thời gian: " + LocalDateTime.now());
    }

    @Pointcut(value = "execution(* com.exercise.rent_book.controller.BookController.payBook(..))")
    public void payMethod() {
    }

    @AfterReturning("payMethod()")
    public void afterPayMethod(JoinPoint joinPoint) {
//        WriteFile.writeFilePay("Trả sách thành công " + joinPoint.getSignature().getName() + " vào thời gian: " + LocalDateTime.now());
        WriteFile.writeFilePay("Trả sách thành công " + "vào thời gian: " + LocalDateTime.now());
        System.out.println("Done " + joinPoint.getSignature().getName() + " vào thời gian: " + LocalDateTime.now());
    }

    @Pointcut(value = "execution(* com.exercise.rent_book.controller.BookController.*(..))")
    public void countMethod() {
    }

    @AfterReturning("countMethod()")
    public void afterReturningMethod(JoinPoint joinPoint) {
        WriteFile.writeFileCount("Số lần truy cập " + ++number +" vào thời gian: " + LocalDateTime.now());
//        System.out.println("Count " + number++ +" vào thời gian: " + LocalDateTime.now());
    }
}
