package com.pjmb.hiberspring.products.entity;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_code")
    private String productCode;

    public Product() {}

    public Product(String productName, String productCode) {
        this.productName = productName;
        this.productCode = productCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String code) {
        this.productCode = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + productName + '\'' +
                ", code='" + productCode + '\'' +
                '}';
    }
}
