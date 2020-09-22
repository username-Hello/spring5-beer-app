package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.IngredientCommand;
import com.springframework.spring5beerapp.converters.IngredientCommandToIngredient;
import com.springframework.spring5beerapp.converters.IngredientToIngredientCommand;
import com.springframework.spring5beerapp.domain.Ingredient;
import com.springframework.spring5beerapp.repositories.BeerRepository;
import com.springframework.spring5beerapp.repositories.IngredientRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final BeerRepository beerRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository,
                                 IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient,
                                 BeerRepository beerRepository) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.beerRepository = beerRepository;
    }

    @Override
    public List<IngredientCommand> getAll() {
        List<IngredientCommand> ingredientCommands = new ArrayList<>();
        ingredientRepository
                .findAll()
                .iterator()
                .forEachRemaining(ingredient -> ingredientCommands
                        .add(ingredientToIngredientCommand.convert(ingredient)));
        return ingredientCommands;
    }

    @Override
    public IngredientCommand findById(Long id) throws NotFoundException {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        if (ingredientOptional.isEmpty()){
            throw new NotFoundException("Ingredient doesn't exist");
        }
        return ingredientToIngredientCommand.convert(ingredientOptional.get());
    }

    @Override
    public IngredientCommand save(IngredientCommand ingredientCommand) {
        Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);
        ingredient.setBeer(beerRepository.findById(ingredientCommand.getRecipeId()).get());
        return ingredientToIngredientCommand
                .convert(ingredientRepository.save(ingredient));
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }
}
