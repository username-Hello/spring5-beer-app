package com.springframework.spring5beerapp.services;


import com.springframework.spring5beerapp.commands.BeerCommand;
import javassist.NotFoundException;

import java.util.List;

public interface BeerService {

    List<BeerCommand> getAll();

    BeerCommand findById(Long id) throws NotFoundException;

    BeerCommand findByName(String name) throws NotFoundException;

    BeerCommand save(BeerCommand beer);

    void deleteById(Long id);
}
