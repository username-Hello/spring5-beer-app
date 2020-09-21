package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.IngredientCommand;
import javassist.NotFoundException;

import java.util.List;

public interface IngredientService {

    List<IngredientCommand> getAll();

    IngredientCommand findById(Long id) throws NotFoundException;

    IngredientCommand save(IngredientCommand ingredient);

    void deleteById(Long id);
}
