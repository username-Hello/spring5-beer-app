package com.springframework.spring5beerapp.repositories;

import com.springframework.spring5beerapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
