package com.j3appdemo.j3_app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j3appdemo.j3_app.models.Product;
import com.j3appdemo.j3_app.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repositoryProduct;


    // public List<Product> findAll() {
    //     return repositoryProduct.findAll();
    // }

    public List<Product> findAll(){
        return repositoryProduct.findAll().stream().map(p ->{
            Double priceImp = p.getPrice() * 1.45d;
            // Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product newProduct = (Product) p.clone();
            // p.setPrice(priceImp.longValue())M
            newProduct.setPrice(priceImp.longValue());
            return newProduct;
        }).collect (Collectors.toList());
    }
    public Product findById(Long id) {
        return repositoryProduct.findById(id);
    }

}
