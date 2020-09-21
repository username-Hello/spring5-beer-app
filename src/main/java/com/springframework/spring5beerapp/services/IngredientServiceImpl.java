package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.IngredientCommand;
import com.springframework.spring5beerapp.converters.IngredientCommandToIngredient;
import com.springframework.spring5beerapp.converters.IngredientToIngredientCommand;
import com.springframework.spring5beerapp.domain.Ingredient;
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

    public IngredientServiceImpl(IngredientRepository ingredientRepository,
                                 IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
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
        return ingredientToIngredientCommand
                .convert(ingredientRepository
                        .save(ingredientCommandToIngredient.convert(ingredientCommand)));
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }
}
