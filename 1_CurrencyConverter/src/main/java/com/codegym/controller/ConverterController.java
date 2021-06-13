package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;

@Controller
public class ConverterController {
    @GetMapping("/converter")
    public String showForm() {
        return "index";
    }

    @PostMapping("/converter")
    public ModelAndView convert(@RequestParam(required = true, name = "usdAmount") String usdAmount){
            ModelAndView modelAndView = new ModelAndView("index");
            Double result = Double.parseDouble(usdAmount) * 20000;
            modelAndView.addObject("usdAmount", usdAmount);
            modelAndView.addObject("result", result);
            return modelAndView;
    }

}
