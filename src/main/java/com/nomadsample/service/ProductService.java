package com.nomadsample.service;

import com.nomadsample.model.Product;

import java.util.List;

public interface ProductService {

     void createProductIndexBulk(List<Product> products);
     void createProductIndex(Product product);
     List<Product> findByName(String name);
}
