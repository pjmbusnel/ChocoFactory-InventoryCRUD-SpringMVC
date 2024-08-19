package com.pjmb.wonka.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Column(name="name")
    private String name;

    @Size(max = 50, message = "Description must be 50 characters or less")
    @Column(name="description")
    private String description;

    @Size(max = 50, message = "Origin must be 50 characters or less")
    @Column(name="origin")
    private String origin;

    @NotBlank(message = "Format is required")
    @Size(min = 3, max = 50, message = "Format must be between 3 and 50 characters")
    @Column(name="format")
    private String format;

    @NotNull(message = "Weight is required")
    @Min(value = 0, message = "Weight must be equal to or greater than 0 grams")
    @Column(name="weight")
    private Double weight;

}
