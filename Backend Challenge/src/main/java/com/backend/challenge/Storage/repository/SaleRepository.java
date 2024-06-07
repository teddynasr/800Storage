package com.backend.challenge.Storage.repository;

import com.backend.challenge.Storage.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {}
