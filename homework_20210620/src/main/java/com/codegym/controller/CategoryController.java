package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView("category/index");
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("newCategory", new Category());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category newCategory) {
        categoryService.save(newCategory);
        return "redirect:/category";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("category/view");
        Category category = categoryService.findById(id).get();
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}/remove")
    public String removeCategory(@PathVariable Long id) {
        categoryService.remove(id);
        return "redirect:/category";
    }
}
