package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.BeerTypeCommand;
import com.springframework.spring5beerapp.domain.BeerType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BeerTypeCommandToBeerType implements Converter<BeerTypeCommand, BeerType> {

    @Override
    public BeerType convert(BeerTypeCommand beerTypeCommand) {
        BeerType beerType = new BeerType();
        beerType.setId(beerTypeCommand.getId());
        beerType.setDescription(beerTypeCommand.getDescription());
        return beerType;
    }
}
