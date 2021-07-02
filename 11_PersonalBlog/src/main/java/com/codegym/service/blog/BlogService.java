package com.codegym.service.blog;

import com.codegym.model.Blog;

import java.util.Optional;

public interface BlogService {
    Iterable<Blog> findAll();

    Iterable<Blog> findAllSortedByDate();

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    void deleteById(Long id);
}
