package com.springframework.spring5beerapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BeerCommand {

    private Long id;
    private String name;
    private DescriptionCommand description;
    private BeerTypeCommand beerType;
    private List<FanCommand> fans = new ArrayList<>();
    private List<ReviewCommand> reviews = new ArrayList<>();
    private List<IngredientCommand> ingredients = new ArrayList<>();
    private SnackCommand snack;
}
