package com.greenleaf.shop.controller;

import com.greenleaf.shop.model.Contact;
import com.greenleaf.shop.repository.ContactRepository;
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

    /**
     * handle database error
     * @param contact
     * @param errors
     * @return
     */

    @PostMapping("/contact/send")
    public String sendMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            return "contact.html";
        }
        contactRepository.save(contact);
        return "redirect:/greenleaf/contact?success=true";
    }

}
