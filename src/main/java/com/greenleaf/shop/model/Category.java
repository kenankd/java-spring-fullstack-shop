package com.greenleaf.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id",nullable = true)
    private Category parentCategory;

    @OneToMany(mappedBy = "subtypeCategory")
    private List<Product> products;
}