package com.codegym.controller;

import com.codegym.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public ModelAndView showIndex(@SessionAttribute Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart/index");
        modelAndView.addObject("products", cart.getProducts());
        return modelAndView;
    }
}
