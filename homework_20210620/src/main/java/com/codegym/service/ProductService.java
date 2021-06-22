package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long id);

    void save(Product product);

    void remove(Long id);

    Page<Product> findAllByNameContaining(String q, Pageable pageable);
}
