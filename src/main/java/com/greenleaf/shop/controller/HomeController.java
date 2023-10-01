package com.greenleaf.shop.controller;

import com.greenleaf.shop.dto.LoginRequest;
import com.greenleaf.shop.model.Contact;
import com.greenleaf.shop.model.Product;
import com.greenleaf.shop.model.User;
import com.greenleaf.shop.repository.ProductRepository;
import com.greenleaf.shop.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/greenleaf")
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = {"/home","","/"})
    public String showHome(){
        return "index";
    }
    @GetMapping("/about")
    public String showAbout(){
        return "about";
    }

    @GetMapping("/contact")
    public String showContact(@RequestParam(value="success",required = false) String success,
                              Model model){
        if(success!=null)
            model.addAttribute("success","Contact message sent!");
        model.addAttribute("contact", new Contact());
        return "contact";
    }
    @RequestMapping(value = "/login", method= {RequestMethod.POST,RequestMethod.GET})
    public String showLogin(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            @RequestParam(value = "register", required = false) String register,
                            Model model){
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Username or Password is incorrect !!";
        } else if (logout != null) {
            errorMessage = "You have been successfully logged out!";
        } else if (register != null) {
            errorMessage = "You registered successfully. Login with registered credentials!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }

    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/greenleaf/login?logout=true";
    }



}
