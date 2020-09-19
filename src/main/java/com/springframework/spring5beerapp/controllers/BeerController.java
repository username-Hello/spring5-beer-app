package com.springframework.spring5beerapp.controllers;

import com.springframework.spring5beerapp.services.BeerService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{id}/show")
    public String showBeer(@PathVariable Long id, Model model) throws NotFoundException {
        model.addAttribute("beer", beerService.findById(id));
        return "beer/show";
    }
}
