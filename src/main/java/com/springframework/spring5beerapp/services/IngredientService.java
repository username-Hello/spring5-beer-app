package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Ingredient;
import javassist.NotFoundException;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getAll();

    Ingredient findById(Long id) throws NotFoundException;

    Ingredient save(Ingredient ingredient);

    void deleteById(Long id);
}
