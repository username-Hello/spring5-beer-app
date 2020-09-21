package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.BeerCommand;
import com.springframework.spring5beerapp.domain.Beer;
import com.springframework.spring5beerapp.domain.Fan;
import com.springframework.spring5beerapp.domain.Ingredient;
import com.springframework.spring5beerapp.domain.Review;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BeerToBeerCommand implements Converter<Beer, BeerCommand> {

    private final DescriptionToDescriptionCommand descriptionToDescriptionCommand;
    private final BeerTypeToBeerTypeCommand beerTypeToBeerTypeCommand;
    private final FanToFanCommand fanToFanCommand;
    private final ReviewToReviewCommand reviewToReviewCommand;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final SnackToSnackCommand snackToSnackCommand;

    public BeerToBeerCommand(DescriptionToDescriptionCommand descriptionToDescriptionCommand,
                             BeerTypeToBeerTypeCommand beerTypeToBeerTypeCommand, FanToFanCommand fanToFanCommand,
                             ReviewToReviewCommand reviewToReviewCommand,
                             IngredientToIngredientCommand ingredientToIngredientCommand,
                             SnackToSnackCommand snackToSnackCommand) {
        this.descriptionToDescriptionCommand = descriptionToDescriptionCommand;
        this.beerTypeToBeerTypeCommand = beerTypeToBeerTypeCommand;
        this.fanToFanCommand = fanToFanCommand;
        this.reviewToReviewCommand = reviewToReviewCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.snackToSnackCommand = snackToSnackCommand;
    }

    @Override
    public BeerCommand convert(Beer beer) {
        BeerCommand beerCommand = new BeerCommand();
        beerCommand.setId(beer.getId());
        beerCommand.setName(beer.getName());
        beerCommand.setDescription(descriptionToDescriptionCommand.convert(beer.getDescription()));
        beerCommand.setBeerType(beerTypeToBeerTypeCommand.convert(beer.getBeerType()));
        if (beer.getFans() != null) {
            beer.getFans()
                    .forEach((Fan fan) -> beerCommand.getFans().add(fanToFanCommand.convert(fan)));
        }
        if (beer.getReviews() != null) {
            beer.getReviews()
                    .forEach((Review review) -> beerCommand.getReviews().add(reviewToReviewCommand.convert(review)));
        }
        if (beer.getIngredients() != null) {
            beer.getIngredients()
                    .forEach((Ingredient ingredient) -> beerCommand.getIngredients()
                            .add(ingredientToIngredientCommand.convert(ingredient)));
        }
        beerCommand.setSnack(snackToSnackCommand.convert(beer.getSnack()));
        return beerCommand;
    }
}
