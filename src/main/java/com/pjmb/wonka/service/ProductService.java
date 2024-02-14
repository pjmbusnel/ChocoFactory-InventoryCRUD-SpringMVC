package com.pjmb.wonka.service;

import com.pjmb.wonka.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(int id);
    Product save(Product theProduct);
    void deleteById(int id);
}
