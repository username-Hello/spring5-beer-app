package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Ingredient;
import com.springframework.spring5beerapp.repositories.IngredientRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAll() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().iterator().forEachRemaining(ingredients::add);
        return ingredients;
    }

    @Override
    public Ingredient findById(Long id) throws NotFoundException {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        if (ingredientOptional.isEmpty()){
            throw new NotFoundException("Ingredient doesn't exist");
        }
        return ingredientOptional.get();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }
}
