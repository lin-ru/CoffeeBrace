package com.github.linru.CoffeeBrace.repositories;

import com.github.linru.CoffeeBrace.entities.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;


@RepositoryRestResource(collectionResourceRel = "card", path = "card")
public interface CardRepo extends PagingAndSortingRepository<Card, UUID>, CrudRepository<Card, UUID> {


}
