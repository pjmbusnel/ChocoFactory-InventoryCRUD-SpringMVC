package com.pjmb.wonka.repository;

import com.pjmb.wonka.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
