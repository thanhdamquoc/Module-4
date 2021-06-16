package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping
    public ModelAndView calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String operator) {
        ModelAndView modelAndView = new ModelAndView("index");
        double result = 0;
        switch (operator) {
            case "Add":
                result = num1 + num2;
                break;
            case "Subtract":
                result = num1 - num2;
                break;
            case "Multiply":
                result = num1 * num2;
                break;
            case "Divide":
                result = num1 / num2;
                break;
        }
        modelAndView.addObject("num1", num1);
        modelAndView.addObject("num2", num2);
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
