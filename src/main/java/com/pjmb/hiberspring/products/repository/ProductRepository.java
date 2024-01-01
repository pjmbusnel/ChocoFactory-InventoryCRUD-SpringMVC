package com.pjmb.hiberspring.products.repository;

import com.pjmb.hiberspring.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="stuff")
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
