package com.greenleaf.shop.controller;

import com.greenleaf.shop.model.Contact;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greenleaf")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    @PostMapping("/contact/send")
    public String sendMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            return "contact.html";
        }
        return "redirect:/greenleaf/contact";
    }
}
