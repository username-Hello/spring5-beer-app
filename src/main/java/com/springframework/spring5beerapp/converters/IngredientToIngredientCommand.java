package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.IngredientCommand;
import com.springframework.spring5beerapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setDescription(ingredient.getDescription());
        return ingredientCommand;
    }
}
