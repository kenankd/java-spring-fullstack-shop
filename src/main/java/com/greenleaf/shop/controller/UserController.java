package com.greenleaf.shop.controller;

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
            return "redirect:/home";
        errors.rejectValue("email","error.invalid.email","User with given email already registered");
        return "register.html";
    }

    @PostMapping("/login/user")
    public ResponseEntity<Void> showLogin(@RequestParam("email") String email,
                            @RequestParam("password") String password){
        try{
            userService.authenticate(email,password);
            return ResponseEntity.ok().build();
        }
        catch(BadCredentialsException ex){
            return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
