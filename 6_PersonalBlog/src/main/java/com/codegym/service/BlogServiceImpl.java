package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.repository.BlogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public boolean save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public boolean remove(Long id) {
        return blogRepository.remove(id);
    }
}
