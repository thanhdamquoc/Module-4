package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/welo")
    public String showHello() {
        return "hello";
    }
}
