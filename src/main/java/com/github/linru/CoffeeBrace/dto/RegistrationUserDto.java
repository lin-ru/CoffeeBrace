package com.github.linru.CoffeeBrace.dto;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String ConfirmPassword;
    private String email;
}
