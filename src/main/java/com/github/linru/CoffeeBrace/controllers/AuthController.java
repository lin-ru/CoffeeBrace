package com.github.linru.CoffeeBrace.controllers;

import com.github.linru.CoffeeBrace.config.security.jwt.JwtTokenUtils;
import com.github.linru.CoffeeBrace.dto.JwtRequest;
import com.github.linru.CoffeeBrace.dto.JwtResponse;
import com.github.linru.CoffeeBrace.exceptions.AppError;
import com.github.linru.CoffeeBrace.services.UserService;
import com.github.linru.CoffeeBrace.services.impl.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserServiceImp userService;
    private final JwtTokenUtils jwtTokenUtils;
    @Autowired
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authReuest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReuest.getUsername(), authReuest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Login or password are not valid."), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authReuest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }
}
