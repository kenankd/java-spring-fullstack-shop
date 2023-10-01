package com.greenleaf.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    // Getters and setters
}
