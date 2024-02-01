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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(CoffeeBraceApplication.class);

    @Autowired
    public UserServiceImp(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUserName(String username) {
        log.info("----Start method: findByUserName ----");
        return userRepo.findByUsername(username);

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("----Start method:loadUserByUsername UserDetails  ----");

        User user = findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("IN findByUserName EXCEPTION: not found by username {}.", username)
        ));
        log.info("IN findByUserName - user: {} found by username {}.", username);


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    @Override
    public User register(User user) {
        log.info("----Start method: register new User ----");
        Role roleUser = roleRepo.findByName("ROLE_USER").get();
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
    public User findById(Long id) {
        log.info("----Start method: findById ----");
        User result = userRepo.findById(id).orElse(null);
        if (result == null) {
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
        if (result != null) {
            userRepo.delete(result);
        }
        log.info("IN delete - user with Id: {} was deleted.", id);
    }
}
