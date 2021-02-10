package com.nomadsample.repositories;

import com.nomadsample.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findByName(String name);
    List<Product> findByNameContaining(String name);
}
