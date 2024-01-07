package com.github.linru.CoffeeBrace.controllers;

import com.github.linru.CoffeeBrace.entities.Card;
import com.github.linru.CoffeeBrace.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(CardController.class);


     @GetMapping("/secured")
    public String getSecuredData() {
        log.info("-------------------");
        log.info("Get request for the secured data");
        log.info("-------------------");
        return "Secured data";

    }

    @GetMapping("/admin")
    public String getAdminData() {
        log.info("-------------------");
        log.info("Get request for the Admin data");
        log.info("-------------------");
        return "Secured data";

    }

    @GetMapping("/info")
    public String getUserInfo(Principal principal) {
        log.info("-------------------");
        log.info("Get request info about user");

        log.info("--> Returned info: " + principal.getName() + " --");
        log.info("-------------------");
        return principal.getName();

    }
}
