package com.codegym.service;

import com.codegym.exception.ProductNotFoundException;
import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Iterable<Product> findAll();

    List<Product> findAllOrderByName();

    Optional<Product> findById(Long id) throws ProductNotFoundException;

    Optional<Product> findByIdNoExceptions(Long id);

    void save(Product product);

    Product saveProduct(Product product);

    void remove(Long id);

    Page<Product> findAllByNameContaining(String q, Pageable pageable);

    Optional<Product> findByIdTest(Long id);

    Iterable<Product> findAllOrderBy(String order);

    List<Product> findAllPaged(Long limit, Long offset);
}
