package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.BeerCommand;
import com.springframework.spring5beerapp.commands.FanCommand;
import com.springframework.spring5beerapp.commands.IngredientCommand;
import com.springframework.spring5beerapp.commands.ReviewCommand;
import com.springframework.spring5beerapp.domain.Beer;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BeerCommandToBeer implements Converter<BeerCommand, Beer> {

    private final DescriptionCommandToDescription descriptionCommandToDescription;
    private final BeerTypeCommandToBeerType beerTypeCommandToBeerType;
    private final FanCommandToFan fanCommandToFan;
    private final ReviewCommandToReview reviewCommandToReview;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final SnackCommandToSnack snackCommandToSnack;

    public BeerCommandToBeer(DescriptionCommandToDescription descriptionCommandToDescription,
                             BeerTypeCommandToBeerType beerTypeCommandToBeerType, FanCommandToFan fanCommandToFan,
                             ReviewCommandToReview reviewCommandToReview,
                             IngredientCommandToIngredient ingredientCommandToIngredient,
                             SnackCommandToSnack snackCommandToSnack) {
        this.descriptionCommandToDescription = descriptionCommandToDescription;
        this.beerTypeCommandToBeerType = beerTypeCommandToBeerType;
        this.fanCommandToFan = fanCommandToFan;
        this.reviewCommandToReview = reviewCommandToReview;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.snackCommandToSnack = snackCommandToSnack;
    }

    @Synchronized
    @Nullable
    @Override
    public Beer convert(BeerCommand beerCommand) {
        Beer beer = new Beer();
        beer.setId(beerCommand.getId());
        beer.setName(beerCommand.getName());
        beer.setDescription(descriptionCommandToDescription.convert(beerCommand.getDescription()));
        beer.setBeerType(beerTypeCommandToBeerType.convert(beerCommand.getBeerType()));
        if (beerCommand.getFans() != null) {
            beerCommand.getFans()
                    .forEach((FanCommand fanCommand) -> beer.getFans().add(fanCommandToFan.convert(fanCommand)));
        }
        if (beerCommand.getReviews() != null) {
            beerCommand.getReviews()
                    .forEach((ReviewCommand reviewCommand) -> beer.getReviews()
                            .add(reviewCommandToReview.convert(reviewCommand)));
        }
        if (beerCommand.getIngredients() != null){
            beerCommand.getIngredients()
                    .forEach((IngredientCommand ingredientCommand) -> beer.getIngredients()
                            .add(ingredientCommandToIngredient.convert(ingredientCommand)));
        }
        beer.setSnack(snackCommandToSnack.convert(beerCommand.getSnack()));
        return beer;
    }
}
