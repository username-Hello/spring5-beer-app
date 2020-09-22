package com.springframework.spring5beerapp.controllers;

import com.springframework.spring5beerapp.commands.IngredientCommand;
import com.springframework.spring5beerapp.services.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/beer/{beerId}/ingredient/new")
    public String addIngredient(@PathVariable String beerId, Model model) {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(beerId));
        model.addAttribute("ingredient", ingredientCommand);
        return "ingredients/createIngredient";
    }

    @PostMapping("/beer/{beerId}/ingredient")
    public String saveIngredient(@PathVariable String beerId, @ModelAttribute IngredientCommand ingredientCommand) {
        ingredientService.save(ingredientCommand);
        return "redirect:/beer/" + ingredientCommand.getRecipeId() + "/update";
    }

    @GetMapping("/beer/{beerId}/ingredient/{ingredientId}/delete")
    public String deleteIngredient(@PathVariable String beerId, @PathVariable String ingredientId) {
        ingredientService.deleteById(Long.valueOf(ingredientId));
        return "redirect:/beer/" + beerId + "/update";
    }
}
