package com.nomadsample.controller;

import com.nomadsample.model.Product;
import com.nomadsample.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product) {
        this.productService.createProductIndex(product);
    }

    @GetMapping("/products/{name}")
    public List<Product> fetchByName(@PathVariable String name) {
        return this.productService.findByName(name);
    }
}
