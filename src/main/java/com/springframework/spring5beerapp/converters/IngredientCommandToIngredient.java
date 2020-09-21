package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.IngredientCommand;
import com.springframework.spring5beerapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientCommand.getId());
        ingredient.setDescription(ingredientCommand.getDescription());
        return ingredient;
    }
}
