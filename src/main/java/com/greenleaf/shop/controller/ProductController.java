package com.greenleaf.shop.controller;

import com.greenleaf.shop.model.Product;
import com.greenleaf.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/greenleaf")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/shop/page/{pageNum}")
    public String showShop(@PathVariable("pageNum") Integer pageNum,
                           @RequestParam(name = "category", required = false) String category,
                           @RequestParam(name = "gender", required = false) String gender,
                           Model model){

        Page<Product> productPage = productService.findProducts(pageNum,category,gender);
        List<Product> products = productPage.getContent();
        model.addAttribute("products",products);
        model.addAttribute("totalPages",productPage.getTotalPages());
        model.addAttribute("currentPage",pageNum);
        model.addAttribute("category",category);
        model.addAttribute("gender",gender);
        return "shop";
    }
}

