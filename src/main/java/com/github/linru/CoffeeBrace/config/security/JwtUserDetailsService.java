//package com.github.linru.CoffeeBrace.config.security;
//
//import com.github.linru.CoffeeBrace.CoffeeBraceApplication;
//import com.github.linru.CoffeeBrace.config.security.jwt.JwtUser;
//import com.github.linru.CoffeeBrace.config.security.jwt.JwtUserFactory;
//import com.github.linru.CoffeeBrace.entities.User;
//import com.github.linru.CoffeeBrace.services.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//    private static final Logger log = LoggerFactory.getLogger(CoffeeBraceApplication.class);
//
//    private final UserService userService;
//
//    @Autowired
//    public JwtUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("----Start method: findById ----");
//        User user = userService.findByUserName(username).get();
//        if (user == null) {
//            throw new UsernameNotFoundException("User with username: "+ username +"not found");
//        }
//        JwtUser jwtUser = JwtUserFactory.create(user);
//
//        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
//        return jwtUser;
//    }
//}
