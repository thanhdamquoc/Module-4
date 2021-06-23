package com.codegym.formatter;

import com.codegym.model.Blog;
import com.codegym.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class BlogFormatter implements Formatter<Blog> {
    @Autowired
    private BlogService blogService;

    public BlogFormatter(BlogService blogService) {
        this.blogService = blogService;
    }

    @Override
    public Blog parse(String text, Locale locale) throws ParseException {
        return blogService.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Blog object, Locale locale) {
        return object.getId().toString();
    }
}
