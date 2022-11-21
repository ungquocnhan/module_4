package com.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public static double calculate(double firstOperand, double secondOperand, String operator) {
        double result = 0.0;
        switch (operator) {
            case "Addition(+)":
                result = firstOperand + secondOperand;
                break;
            case "Subtraction(-)":
                result = firstOperand - secondOperand;
                break;
            case "Multiplication(*)":
                result = firstOperand * secondOperand;
                break;
            case "Division(/)":
                if (secondOperand != 0)
                    result = firstOperand / secondOperand;
                else
                    throw new ArithmeticException("Second Operand Not 0");
                break;
            default:
                throw new RuntimeException("Unsupported operation");
        }
        return result;
    }
}
