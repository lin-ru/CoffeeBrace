package com.github.linru.CoffeeBrace.services;

import com.github.linru.CoffeeBrace.entities.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUserName(String username);

    User findById(Long id);

    void delete(Long id);
}
