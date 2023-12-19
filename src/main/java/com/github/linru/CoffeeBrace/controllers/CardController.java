package com.github.linru.CoffeeBrace.controllers;

import com.github.linru.CoffeeBrace.entities.Card;
import com.github.linru.CoffeeBrace.repositories.CardRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CardController {

    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(CardController.class);

    private final CardRepo cardRepo;


    public CardController(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    @GetMapping("/cards")
    public Iterable<Card> getAllCards() {
        Iterable<Card> cards = cardRepo.findAll();
        log.info("All cards requested");
        log.info("-------------------");
        cards.forEach(card -> log.info(card.toString()));
        return cards;
    }

}
