package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface BlogRepository {
    public List<Blog> findAll();
    public Blog findById(Long id);
    public boolean save(Blog blog);
    public boolean remove(Long id);
}
