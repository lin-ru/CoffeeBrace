package com.github.linru.CoffeeBrace;

import com.github.linru.CoffeeBrace.entities.Card;
import com.github.linru.CoffeeBrace.repositories.CardRepo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoffeeBraceApplication {

    private static final Logger log = LoggerFactory.getLogger(CoffeeBraceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CoffeeBraceApplication.class, args);
    }

    @Bean
    public CommandLineRunner prepareDBCard(CardRepo cardRepo) {
        return args -> {
            cardRepo.save(new Card("FirstCard", "Description of first Card"));
            cardRepo.save(new Card("TwoCard", "Description of 2 Card"));
            cardRepo.save(new Card("Card 3", "Description of 3 Card"));
            log.info("All cards saved");
            log.info("-------------------");
            cardRepo.findAll().forEach(card -> log.info(card.toString()));
        };
    }
}
