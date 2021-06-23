package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Comment;
import com.codegym.model.IBlogComment;
import com.codegym.service.blog.BlogService;
import com.codegym.service.category.CategoryService;
import com.codegym.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ModelAndView showIndex(@PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs", blogService.getBlogAndComment());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories", categoryService.findAll(pageable));
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
        blogService.deleteById(id);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/like")
    public String likeBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id).get();
        blog.setLikes(blog.getLikes()+1);
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/unlike")
    public String unlikeBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id).get();
        blog.setLikes(blog.getLikes()-1);
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs", blogService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable Long id,@PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("view");
        Blog blog = blogService.findById(id).get();
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("comments", commentService.findAllByBlog(blog, pageable));
        modelAndView.addObject("newComment", new Comment());
        return modelAndView;
    }

    @GetMapping("/{id}/view/like")
    public String likeBlogView(@PathVariable Long id) {
        Blog blog = blogService.findById(id).get();
        blog.setLikes(blog.getLikes()+1);
        blogService.save(blog);
        return "redirect:/blog/" + id + "/view" ;
    }

    @GetMapping("/{id}/view/unlike")
    public String unlikeBlogView(@PathVariable Long id) {
        Blog blog = blogService.findById(id).get();
        blog.setLikes(blog.getLikes()-1);
        blogService.save(blog);
        return "redirect:/blog/" + id + "/view";
    }

    @PostMapping("/{id}/view/comment")
    public String submitComment(@ModelAttribute Comment newComment, @PathVariable(name = "id") Long blogId) {
        newComment.setDate(new Date());
        newComment.setBlog(blogService.findById(blogId).get());
        commentService.save(newComment);
        return "redirect:/blog/" + blogId + "/view";
    }
}
