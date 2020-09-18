package com.springframework.spring5beerapp.controllers;

import com.springframework.spring5beerapp.services.BeerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/", "/index"})
public class IndexController {

    private final BeerService beerService;

    public IndexController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping()
    public String getGritting(Model model){
        model.addAttribute("beers", beerService.getAll());
        return "index";
    }
}
