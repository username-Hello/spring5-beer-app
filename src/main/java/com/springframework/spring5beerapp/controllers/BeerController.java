package com.springframework.spring5beerapp.controllers;

import com.springframework.spring5beerapp.commands.BeerCommand;
import com.springframework.spring5beerapp.domain.Beer;
import com.springframework.spring5beerapp.services.BeerService;
import com.springframework.spring5beerapp.services.BeerTypeService;
import com.springframework.spring5beerapp.services.SnackService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;
    private final BeerTypeService beerTypeService;
    private final SnackService snackService;

    public BeerController(BeerService beerService, BeerTypeService beerTypeService, SnackService snackService) {
        this.beerService = beerService;
        this.beerTypeService = beerTypeService;
        this.snackService = snackService;
    }

    @GetMapping("/{id}/show")
    public String showBeer(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute("beer", beerService.findById(Long.valueOf(id)));
        return "beer/show";
    }

    @GetMapping("/new")
    public String createNewBeer(Model model) {
        model.addAttribute("beer", new Beer());
        model.addAttribute("beerTypes", beerTypeService.getAll());
        return "beer/createBeer";
    }

    @GetMapping("/{id}/update")
    public String updateBeer(@PathVariable String id, Model model) throws NotFoundException {
        BeerCommand beerCommand = beerService.findById(Long.valueOf(id));
        model.addAttribute("beer", beerCommand);
        model.addAttribute("beerTypes", beerTypeService.getAll());
        model.addAttribute("snacks", snackService.getAll());
        return "beer/updateBeer";
    }

    @PostMapping("/")
    public String saveOrUpdate(@ModelAttribute("beer") BeerCommand beerCommand) throws NotFoundException {
        BeerCommand savedBeerCommand = beerService.update(beerCommand);
        return "redirect:/beer/" + savedBeerCommand.getId() + "/show";
    }

}
