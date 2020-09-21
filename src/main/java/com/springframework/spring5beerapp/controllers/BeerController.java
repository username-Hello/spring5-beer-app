package com.springframework.spring5beerapp.controllers;

import com.springframework.spring5beerapp.domain.Beer;
import com.springframework.spring5beerapp.services.BeerService;
import com.springframework.spring5beerapp.services.BeerTypeService;
import com.springframework.spring5beerapp.services.FanService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;
    private final BeerTypeService beerTypeService;
    private final FanService fanService;

    public BeerController(BeerService beerService, BeerTypeService beerTypeService, FanService fanService) {
        this.beerService = beerService;
        this.beerTypeService = beerTypeService;
        this.fanService = fanService;
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
        model.addAttribute("beer", beerService.findById(Long.valueOf(id)));
        model.addAttribute("beerTypes", beerTypeService.getAll());
        model.addAttribute("fans", fanService.getAll());
        return "beer/updateBeer";
    }

    @PostMapping()
    public String saveOrUpdate(@ModelAttribute Beer beer) {
        Beer savedBeer = beerService.save(beer);
        return "redirect:/beer/" + savedBeer.getId() + "/show";
    }

}
