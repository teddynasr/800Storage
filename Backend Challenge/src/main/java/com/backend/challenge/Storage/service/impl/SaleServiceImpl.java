package com.backend.challenge.Storage.service.impl;

import com.backend.challenge.Storage.entity.Sale;
import com.backend.challenge.Storage.repository.SaleRepository;
import com.backend.challenge.Storage.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    @Lazy
    SaleRepository saleRepository;

    @Override
    public List<Sale> fetchSales() {
        return saleRepository.findAll();
    }

    @Override
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).isPresent()?saleRepository.findById(id).get():null;
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
