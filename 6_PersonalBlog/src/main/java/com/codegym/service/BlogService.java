package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Long id);

    void save(Blog blog);

    void deleteById(Long id);

}
