package com.case_study.case_study_module_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Scanner;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CaseStudyModule4Application {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyModule4Application.class, args);
    }

}
