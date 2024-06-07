package com.backend.challenge.Storage.controller;

import com.backend.challenge.Storage.entity.Product;
import com.backend.challenge.Storage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    @Lazy
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model){
        model.addAttribute("products", productService.fetchProducts());
        return "products";
    }

    @GetMapping("/products/new")
    public String createProductForm(Model model){
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "updateProduct";
    }

    @PostMapping("/products/{id}")
    public String saveUpdatedProduct(@ModelAttribute("product")Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
