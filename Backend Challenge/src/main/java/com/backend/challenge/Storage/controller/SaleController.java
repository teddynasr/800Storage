package com.backend.challenge.Storage.controller;

import com.backend.challenge.Storage.entity.Sale;
import com.backend.challenge.Storage.service.ClientService;
import com.backend.challenge.Storage.service.ProductService;
import com.backend.challenge.Storage.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaleController {
    @Autowired
    @Lazy
    ClientService clientService;
    @Autowired
    @Lazy
    ProductService productService;
    @Autowired
    @Lazy
    SaleService saleService;

    @GetMapping("/sales")
    public String showSales(Model model){
        model.addAttribute("sales", saleService.fetchSales());
        return "sales";
    }

    @GetMapping("/sales/new")
    public String createSale(Model model){
        model.addAttribute("sale", new Sale());
        model.addAttribute("clients", clientService.fetchClients());
        model.addAttribute("products", productService.fetchProducts());
        return "createSale";
    }

    @PostMapping("/sales")
    public String saveSale(@ModelAttribute(name="sale")Sale sale){
        saleService.saveSale(sale);
        return "redirect:/sales";
    }

    @GetMapping("/sales/edit/{id}")
    public String updateSale(@PathVariable Long id, Model model){
        model.addAttribute("sale", saleService.getSaleById(id));
        model.addAttribute("clients", clientService.fetchClients());
        model.addAttribute("products", productService.fetchProducts());
        return "updateSale";
    }

    @PostMapping("/sales/{id}")
    public String saveUpdatedSale(@ModelAttribute(name="sale")Sale sale){
        Sale oldSale=saleService.getSaleById(sale.getId());
        System.out.println("Old Sale: "+oldSale);
        System.out.println("New Sale: "+sale);
        saleService.saveSale(sale);
        return "redirect:/sales";
    }

    @GetMapping("/sales/delete/{id}")
    public String deleteSale(@PathVariable Long id){
        saleService.deleteSale(id);
        return "redirect:/sales";
    }
}
