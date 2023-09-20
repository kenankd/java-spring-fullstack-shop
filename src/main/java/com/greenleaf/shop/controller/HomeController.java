package com.greenleaf.shop.controller;

import com.greenleaf.shop.dto.LoginRequest;
import com.greenleaf.shop.model.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greenleaf")
public class HomeController {
    @RequestMapping(value = {"/home","","/"})
    public String showHome(){
        var b= SecurityContextHolder.getContext().getAuthentication();
        return "index";
    }
    @RequestMapping("/about")
    public String showAbout(){
        return "about";
    }

    @RequestMapping("/contact")
    public String showContact(){
        return "contact";
    }

    @RequestMapping("/shop")
    public String showShop(){
        return "shop";
    }

    @RequestMapping("/login")
    public String showLogin(Model model){
        model.addAttribute("loginrequest",new LoginRequest());
        return "login";
    }

    @RequestMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }



}
