package com.greenleaf.shop.controller;

import com.greenleaf.shop.dto.LoginRequest;
import com.greenleaf.shop.model.User;
import com.greenleaf.shop.service.UserService;
import com.greenleaf.shop.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/greenleaf")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register/user")
    public String registerUser(@Valid @ModelAttribute("user") User user, Errors errors){
        if(errors.hasErrors()){
            log.info("Error in validation: " + errors.getAllErrors().toString());
            return "register.html";
        }
        ResponseEntity<ApiResponse<User>> response = userService.registerUser(user);
        if(response.getBody().isSuccessful())
            return "redirect:/greenleaf/home";
        errors.rejectValue("email","error.invalid.email","User with given email already registered");
        return "register.html";
    }

    @PostMapping("/login/user")
    public String showLogin(@Valid @ModelAttribute("loginrequest")LoginRequest loginRequest, Errors errors, Model model){
        if(errors.hasErrors()){
            log.info("Error in validation: " + errors.getAllErrors().toString());
            return "login.html";
        }
        try{
            userService.authenticate(loginRequest.getEmail(),loginRequest.getPassword());
            return "redirect:/greenleaf/home";
        }
        catch(BadCredentialsException ex){
            model.addAttribute("errorMessage", "Invalid credentials");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Something went wrong");
        }
        return "login.html";
    }
}
