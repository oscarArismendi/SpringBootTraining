package com.j3appdemo.j3_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j3appdemo.j3_app.models.Product;
import com.j3appdemo.j3_app.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class BaseController {
    @Autowired
    private ProductService serviceProduct;

    @GetMapping
    public List<Product> showAll(){
        return serviceProduct.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return serviceProduct.findById(id);
    }
    
}
