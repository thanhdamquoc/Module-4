package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView("/login/index", "user", new User());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView validateUser(@ModelAttribute User user, HttpServletRequest request) {
        Optional<User> userOptional = userService.findByUsername(user.getUsername());
        if (userOptional.isPresent() && (userOptional.get().getPassword().equals(user.getPassword()))) {
            request.getSession().setAttribute("loginUser", userOptional.get());
            return new ModelAndView("redirect:/blog");
        } else {
            return new ModelAndView("/login/index");
        }
    }
}
