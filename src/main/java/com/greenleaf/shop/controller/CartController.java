package com.greenleaf.shop.controller;

import com.greenleaf.shop.model.CartItem;
import com.greenleaf.shop.model.Product;
import com.greenleaf.shop.model.ShoppingCart;
import com.greenleaf.shop.model.User;
import com.greenleaf.shop.repository.CartItemRepository;
import com.greenleaf.shop.repository.CartRepository;
import com.greenleaf.shop.repository.ProductRepository;
import com.greenleaf.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/greenleaf")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/cart")
    public String getCart(Model model){
        ShoppingCart shoppingCart = cartService.getMyShoppingCart();
        List<CartItem> cartItems = cartItemRepository.findAll();
        model.addAttribute("cartItems",cartItems);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("product-id") String id){
        Product product = productRepository.findById(Integer.parseInt(id)).get();
        ShoppingCart shoppingCart = cartService.getMyShoppingCart();
        CartItem cartItem = new CartItem();
        cartItem.setCart(shoppingCart);
        cartItem.setProduct(product);
        cartItem.setSize("S");
        cartItem.setQuantity(1);
        cartItemRepository.save(cartItem);
        return "redirect:/greenleaf/shop/details";

    }
}
