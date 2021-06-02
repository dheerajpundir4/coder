package com.qwetzal.coder.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message="Please provide an email")
    private String email;

    @NotBlank(message = "Please enter a password")
    private String password;
}
