package com.qwetzal.coder.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "username can't be empty")
    @Min(value = 3, message = "Username shoudld be greater than 2 characters")
    private String username;

    @NotBlank(message = "Please enter ful name")
    private String fullName;

    @Email(message = "Email is invalid")
    private String email;
}
