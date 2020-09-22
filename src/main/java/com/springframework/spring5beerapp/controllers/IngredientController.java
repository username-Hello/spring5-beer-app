package com.springframework.spring5beerapp.controllers;

import com.springframework.spring5beerapp.commands.IngredientCommand;
import com.springframework.spring5beerapp.services.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredient/new")
    public String addIngredient(Model model){
        model.addAttribute("ingredient", new IngredientCommand());
        return "redirect:/beer/new";
    }
}
