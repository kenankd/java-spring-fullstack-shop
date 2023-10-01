package com.greenleaf.shop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private ShoppingCart cart;

    private int quantity;
    private String size;
    // Getters and setters
}