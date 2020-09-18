package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Snack;
import javassist.NotFoundException;

import java.util.List;

public interface SnackService {

    List<Snack> getAll();

    Snack findById(Long id) throws NotFoundException;

    Snack save(Snack snack);

    void deleteById(Long id);
}
