package com.greenleaf.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    private double discount;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable=false)
    private String gender;

    @Column(nullable=false)
    @Min(1)
    @Max(5)
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "subtype_category_id")
    private Category subtypeCategory;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

}