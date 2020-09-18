package com.springframework.spring5beerapp.repositories;

import com.springframework.spring5beerapp.domain.BeerType;
import org.springframework.data.repository.CrudRepository;


public interface BeerTypeRepository extends CrudRepository<BeerType, Long> {
}
