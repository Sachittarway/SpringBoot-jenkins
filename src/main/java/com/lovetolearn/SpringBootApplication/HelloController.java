package com.lovetolearn.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot!";
    }
    @GetMapping("/calculate")
    public String calculate(
        @RequestParam double num1,
        @RequestParam double num2,
        @RequestParam String operation) {

        double result;
        switch (operation.toLowerCase()) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    return "Error: Cannot divide by zero!";
                }
                result = num1 / num2;
                break;
            default:
                return "Invalid operation! Use: add, subtract, multiply, or divide.";
        }

        return "Result: " + result;
    }
}
