package com.j3appdemo.j3_app.service;

import java.util.List;

import com.j3appdemo.j3_app.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
