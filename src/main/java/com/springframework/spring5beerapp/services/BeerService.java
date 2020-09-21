package com.springframework.spring5beerapp.services;


import com.springframework.spring5beerapp.domain.Beer;
import javassist.NotFoundException;

import java.util.List;

public interface BeerService {

    List<Beer> getAll();

    Beer findById(Long id) throws NotFoundException;

    Beer findByName(String name) throws NotFoundException;

    Beer createBeer();

    Beer save(Beer beer);

    void deleteById(Long id);
}
