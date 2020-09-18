package com.springframework.spring5beerapp.services;


import com.springframework.spring5beerapp.domain.BeerType;
import javassist.NotFoundException;

import java.util.List;

public interface BeerTypeService{

    List<BeerType> getAll();

    BeerType findById(Long id) throws NotFoundException;

    BeerType save(BeerType beerType);

    void deleteById(Long id);
}
