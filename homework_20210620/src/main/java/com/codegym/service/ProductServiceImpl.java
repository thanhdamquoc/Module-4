package com.codegym.service;

import com.codegym.exception.ProductNotFoundException;
import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllOrderByName() {
        return productRepository.findAllOrderByName();
    }

    @Override
    public Optional<Product> findById(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new ProductNotFoundException();
        }
        return productOptional;
    }

    @Override
    public Optional<Product> findByIdNoExceptions(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByNameContaining(String q, Pageable pageable) {
        return productRepository.findAllByNameContaining(q, pageable);
    }

    @Override
    public Optional<Product> findByIdTest(Long id) {
        return productRepository.findByIdTest(id);
    }

    @Override
    public Iterable<Product> findAllOrderBy(String order) {
        return productRepository.findAllOrderBy("p." + order);
    }

    @Override
    public List<Product> findAllPaged(Long limit, Long offset) {
        return productRepository.findAllPaged(limit, offset);
    }
}
