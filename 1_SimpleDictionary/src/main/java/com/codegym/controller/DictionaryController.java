package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String showForm(){
        return "index";
    }

    @PostMapping("/")
    public ModelAndView translate(@RequestParam(name = "englishWord") String englishWord){
        ModelAndView modelAndView = new ModelAndView("index");
        String vietnameseWord = "";
        switch (englishWord) {
            case "dog":
                vietnameseWord = "dawg";
                break;
            case "cat":
                vietnameseWord = "meow";
                break;
        }
        modelAndView.addObject("englishWord", englishWord);
        modelAndView.addObject("vietnameseWord", vietnameseWord);
        return modelAndView;
    }
}
