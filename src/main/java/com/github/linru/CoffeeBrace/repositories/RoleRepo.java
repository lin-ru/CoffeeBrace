package com.github.linru.CoffeeBrace.repositories;

import com.github.linru.CoffeeBrace.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends CrudRepository <Role, Integer> {
    Role findByName(String name);
}
