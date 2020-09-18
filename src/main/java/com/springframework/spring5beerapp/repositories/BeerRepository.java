package com.springframework.spring5beerapp.repositories;

import com.springframework.spring5beerapp.domain.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BeerRepository extends CrudRepository<Beer, Long> {

    Optional<Beer> findBeerByName(String name);
}
