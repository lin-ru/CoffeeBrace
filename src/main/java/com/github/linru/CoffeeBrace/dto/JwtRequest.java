package com.github.linru.CoffeeBrace.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;

}
