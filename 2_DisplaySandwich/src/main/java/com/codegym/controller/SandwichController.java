package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    @GetMapping
    public String home(){
        return "index";
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("message", "Added successfully");
        modelAndView.addObject("condiment",condiment);
        return modelAndView;
    }
}
