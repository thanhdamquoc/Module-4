package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iPhone", 100, "phone", "Apple"));
        products.add(new Product(2, "Samsung", 120, "phone", "Samsung"));
        products.add(new Product(3, "Xiaomi", 130, "phone", "China"));
        products.add(new Product(4, "Nokia", 80, "phone", "Europe"));
        products.add(new Product(5, "Blackberry", 90, "phone", "USA"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean add(Product product) {
        products.add(product);
        return true;
    }

    @Override
    public boolean update(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        Product product = findById(id);
        products.remove(product);
        return true;
    }
}
