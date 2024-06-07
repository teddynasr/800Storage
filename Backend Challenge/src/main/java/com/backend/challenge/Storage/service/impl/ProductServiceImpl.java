package com.backend.challenge.Storage.service.impl;

import com.backend.challenge.Storage.entity.Product;
import com.backend.challenge.Storage.repository.ProductRepository;
import com.backend.challenge.Storage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Lazy
    private ProductRepository productRepository;

    @Override
    public List<Product> fetchProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).isPresent()?productRepository.findById(id).get():null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
