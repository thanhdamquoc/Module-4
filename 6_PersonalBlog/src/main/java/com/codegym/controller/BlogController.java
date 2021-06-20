package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs", blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute Blog blog) {
        blog.setDate(new Date());
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/remove")
    public String removeBlog(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/like")
    public String likeBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        blog.setLikes(blog.getLikes()+1);
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/unlike")
    public String unlikeBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        blog.setLikes(blog.getLikes()-1);
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs", blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }
}
