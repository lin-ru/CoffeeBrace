package com.github.linru.CoffeeBrace.config.security.jwt;

import com.github.linru.CoffeeBrace.entities.Status;
import com.github.linru.CoffeeBrace.entities.User;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getPassword(),
                user.getEmail(),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdated(),
                null
        );
    }
}
