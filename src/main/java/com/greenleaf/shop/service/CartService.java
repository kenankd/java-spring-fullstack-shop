package com.greenleaf.shop.service;

import com.greenleaf.shop.model.ShoppingCart;
import com.greenleaf.shop.model.User;
import com.greenleaf.shop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    public ShoppingCart getMyShoppingCart(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return cartRepository.findByUser(user);
    }
}
