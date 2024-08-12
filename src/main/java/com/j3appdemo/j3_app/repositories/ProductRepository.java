package com.j3appdemo.j3_app.repositories;

import java.util.List;

import com.j3appdemo.j3_app.models.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
