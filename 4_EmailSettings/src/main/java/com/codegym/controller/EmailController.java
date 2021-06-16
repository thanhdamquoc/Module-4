package com.codegym.controller;

import com.codegym.model.EmailSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/email")
public class EmailController {
    EmailSettings emailSettings = new EmailSettings("Vietnamese", 10, true, "Thanh Dam");

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/edit")
    public ModelAndView showEditForm() {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("emailSettings", emailSettings);
        modelAndView.addObject("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("sizes", new int[] {5, 10, 15, 25, 50, 100});
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateSettings(@ModelAttribute(name="emailSettings") EmailSettings newEmailSettings) {
        emailSettings = newEmailSettings;
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "Your email settings have been successfully updated");
        return modelAndView;
    }
}
