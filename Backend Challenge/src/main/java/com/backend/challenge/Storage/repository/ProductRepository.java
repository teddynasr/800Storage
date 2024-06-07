package com.backend.challenge.Storage.repository;

import com.backend.challenge.Storage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
