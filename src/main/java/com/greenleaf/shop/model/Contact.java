package com.greenleaf.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message="Email is required")
    @Email(message="Please provide a valid email")
    private String email;

    @NotBlank(message="Name is required")
    @Size(min=5, max=30,message="Invalid name length")
    private String name;

    @NotBlank(message="Subject is required")
    @Size(min=5,max=30,message="Invalid subject length")
    private String subject;

    @NotBlank(message="Can't send blank message")
    @Size(min=5, max=300,message = "Invalid message length")
    private String message;
}
