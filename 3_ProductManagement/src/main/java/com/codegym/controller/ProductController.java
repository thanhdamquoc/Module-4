package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("view");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return  modelAndView;
    }

    @GetMapping("/{id}/remove")
    public ModelAndView removeProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        boolean isRemoved = productService.remove(id);
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("message", isRemoved ? "product removed successfully" : "product NOT removed");
        return  modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView("index");
        boolean isAdded = productService.add(product);
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("message", isAdded ? "product added successfully" : "product NOT added");
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editProduct(int id,@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("index");
        boolean isUpdated = productService.update(id, product);
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("message", isUpdated ? "product updated successfully" : "product NOT updated");
        return modelAndView;
    }
}
