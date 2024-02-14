package com.pjmb.wonka.service;

import com.pjmb.wonka.entity.Product;
import com.pjmb.wonka.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository theProductRepo) {
        this.productRepo = theProductRepo;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> result = productRepo.findById(id);
        Product theProduct;
        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            throw new RuntimeException("Did not find product id - " + id);
        }
        return theProduct;
    }

    @Override
    @Transactional
    public Product save(Product theProduct) {
        return productRepo.save(theProduct);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        productRepo.deleteById(id);
    }


}
