package com.github.linru.CoffeeBrace.services.impl;

import com.github.linru.CoffeeBrace.CoffeeBraceApplication;
import com.github.linru.CoffeeBrace.entities.Role;
import com.github.linru.CoffeeBrace.entities.Status;
import com.github.linru.CoffeeBrace.entities.User;
import com.github.linru.CoffeeBrace.repositories.RoleRepo;
import com.github.linru.CoffeeBrace.repositories.UserRepo;
import com.github.linru.CoffeeBrace.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(CoffeeBraceApplication.class);

    @Autowired
    public UserServiceImp(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("----");
        return null;
    }

    @Override
    public User register(User user) {
        log.info("Start method: register new User ----");
        Role roleUser = roleRepo.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        User regeisteredUser = userRepo.save(user);
        log.info("IN register - user: {} successfully registered", regeisteredUser);
        return regeisteredUser;
    }

    @Override
    public List<User> getAll() {
        log.info("----Start method: getAll users ----");
        List<User> result = userRepo.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUserName(String username) {
        log.info("----Start method: findByUserName ----");
        User result = userRepo.findByUsername(username).orElse(null);
        log.info("IN findByUserName - user: {} found by username {}.", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {
        log.info("----Start method: findById ----");
        User result = userRepo.findById(id).orElse(null);
        if (result==null) {
            log.warn("IN findById - no user found by Id {}.", id);
            return null;
        }
        log.info("IN findById - user: {} found by Id {}.", result, id);
        return result;
    }

    @Override
    public void delete(Long id) {
        log.info("----Start method: delete ----");
        User result = userRepo.findById(id).orElse(null);
        if (result!=null) {
            userRepo.delete(result);
        }
        log.info("IN delete - user with Id: {} was deleted.", id);
    }
}
