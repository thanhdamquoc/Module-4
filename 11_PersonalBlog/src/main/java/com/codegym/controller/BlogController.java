package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.LoginForm;
import com.codegym.model.User;
import com.codegym.service.blog.BlogService;
import com.codegym.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs", blogService.findAllSortedByDate());
        modelAndView.addObject("loginForm", new LoginForm());
        Object loginUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Long loginUserId = null;
        if (loginUser instanceof UserDetails) {
            String loginUsername = ((UserDetails) loginUser).getUsername();
            loginUserId = userService.findByUsername(loginUsername).get().getId();
        }

        modelAndView.addObject("loginUserId", loginUserId);
        return modelAndView;
    }

    @GetMapping("/blogs/{id}/delete")
    public ModelAndView deleteBlog(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()) {
            blogService.deleteById(id);
        }
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/blogs")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        blog.setDate(new Date());
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> findAll() {
        Iterable<Blog> blogs = blogService.findAllSortedByDate();
        if (blogs.iterator().hasNext()) {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
