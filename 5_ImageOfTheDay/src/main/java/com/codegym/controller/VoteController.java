package com.codegym.controller;

import com.codegym.model.Vote;
import com.codegym.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @GetMapping
    public ModelAndView showImage() {
        ModelAndView modelAndView = new ModelAndView("index");
        int[] votes = voteService.findTotalByDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        modelAndView.addObject("votes", votes);
        return modelAndView;
    }

    @GetMapping("/vote/{star}")
    public String submitVote(@PathVariable int star) {
        Vote vote = new Vote(null, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), star);
        voteService.add(vote);
        return "redirect:/";
    }
}
