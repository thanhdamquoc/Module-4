package com.codegym.simplecustomermanagementspringboot.controller;

import com.codegym.simplecustomermanagementspringboot.model.Customer;
import com.codegym.simplecustomermanagementspringboot.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showCustomerList() {
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("newCustomer", new Customer());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer newCustomer) {
        customerService.save(newCustomer);
        return "redirect:/customers";
    }

}
