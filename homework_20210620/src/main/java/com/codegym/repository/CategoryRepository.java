package com.codegym.repository;

import com.codegym.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
