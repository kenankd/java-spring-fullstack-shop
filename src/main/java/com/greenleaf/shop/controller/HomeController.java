package com.greenleaf.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"/home","","/"})
    public String showHome(){
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
    public String showLogin(){
        return "login";
    }
}
