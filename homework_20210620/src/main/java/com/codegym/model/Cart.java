package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public boolean isInShoppingCart(Product product) {
        for (Product cartProduct : products.keySet()) {
            if (cartProduct.getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public void add(Product product) {
        if (isInShoppingCart(product)) {
            Integer newQuantity = products.get(product) + 1;
            products.put(product, newQuantity);
        } else {
            products.put(product, 1);
        }
    }
}
