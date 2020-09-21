package com.springframework.spring5beerapp.services;


import com.springframework.spring5beerapp.commands.BeerTypeCommand;
import javassist.NotFoundException;

import java.util.List;

public interface BeerTypeService{

    List<BeerTypeCommand> getAll();

    BeerTypeCommand findById(Long id) throws NotFoundException;

    BeerTypeCommand save(BeerTypeCommand beerType);

    void deleteById(Long id);
}
