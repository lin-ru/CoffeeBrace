package com.github.linru.CoffeeBrace.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "cards")
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    UUID id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Card[id=%s, title='%s', description='%s']", id, title, description);
    }
}
