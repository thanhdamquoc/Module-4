package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public Product findById(int id);
    public boolean add(Product product);
    public boolean update(int id, Product product);
    public boolean remove(int id);
}
