package com.github.linru.CoffeeBrace.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
