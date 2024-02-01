package com.github.linru.CoffeeBrace.services;

import com.github.linru.CoffeeBrace.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);

    List<User> getAll();

    Optional<User> findByUserName(String username);

    User findById(Long id);

    void delete(Long id);
}
