package com.backend.challenge.Storage.service;

import com.backend.challenge.Storage.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> fetchProducts();
    void saveProduct(Product product);
    Product getProductById(Long id);
    void deleteProduct(Long id);
}
