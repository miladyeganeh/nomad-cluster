package com.nomadsample.service;

import com.nomadsample.model.Product;
import com.nomadsample.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProductIndexBulk(List<Product> products) {
        productRepository.saveAll(products);
    }

    @Override
    public void createProductIndex(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findByName(String productName) {
       return this.productRepository.findByName(productName);
    }
}
