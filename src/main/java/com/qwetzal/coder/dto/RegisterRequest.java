package com.qwetzal.coder.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Accessors(chain = true)
public class RegisterRequest {

    @NotBlank(message = "username can't be empty")
    @Size(min = 3, message = "Username shoudld be greater than 2 characters")
    private String username;

    @NotBlank(message = "Enter your full name")
    private String fullName;

    @NotBlank(message = "Please enter an email")
    @Email(message = "Please provide an email")
    private String email;

    @NotBlank(message = "Please enter a password")
    private String password;
}
