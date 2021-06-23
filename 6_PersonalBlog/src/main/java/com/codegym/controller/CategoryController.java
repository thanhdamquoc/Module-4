package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView showIndex(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/category/index");
        modelAndView.addObject("categories", categoryService.findAll(pageable));
        modelAndView.addObject("newCategory", new Category());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category newCategory) {
        categoryService.save(newCategory);
        return "redirect:/category";
    }
}
