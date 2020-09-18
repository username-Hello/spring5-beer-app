package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.BeerType;
import com.springframework.spring5beerapp.domain.Fan;
import javassist.NotFoundException;

import java.util.List;

public interface FanService {

    List<Fan> getAll();

    Fan findById(Long id) throws NotFoundException;

    Fan save(Fan fan);

    void deleteById(Long id);
}
