package com.greenleaf.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Contact {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message="Email is required")
    @Email(message="Please provide a valid email")
    private String email;

    @NotBlank(message="Name is required")
    private String name;

    @NotBlank(message="Subject is required")
    private String subject;

    @NotBlank(message="Can't send blank message")
    private String message;
}
