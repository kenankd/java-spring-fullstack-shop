package com.greenleaf.shop.repository;

import com.greenleaf.shop.model.ShoppingCart;
import com.greenleaf.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<ShoppingCart, Integer> {
    ShoppingCart findByUser(User user);
}
