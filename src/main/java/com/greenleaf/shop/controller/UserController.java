package com.greenleaf.shop.controller;

import com.greenleaf.shop.model.User;
import com.greenleaf.shop.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("user") User user, Errors errors){
        if(errors.hasErrors()){
            log.info("Error in validation: " + errors.getAllErrors().toString());
            return "register.html";
        }
        userService.registerUser(user);
        return "redirect:/home";
    }
}
