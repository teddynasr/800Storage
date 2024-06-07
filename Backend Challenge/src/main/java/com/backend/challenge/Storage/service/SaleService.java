package com.backend.challenge.Storage.service;

import com.backend.challenge.Storage.entity.Sale;
import java.util.*;

public interface SaleService {
    List<Sale> fetchSales();
    void saveSale(Sale sale);
    Sale getSaleById(Long id);
    void deleteSale(Long id);
}
