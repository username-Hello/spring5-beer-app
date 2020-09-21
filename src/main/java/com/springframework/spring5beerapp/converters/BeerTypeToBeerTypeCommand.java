package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.BeerTypeCommand;
import com.springframework.spring5beerapp.domain.BeerType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BeerTypeToBeerTypeCommand implements Converter<BeerType, BeerTypeCommand> {
    @Override
    public BeerTypeCommand convert(BeerType beerType) {
        BeerTypeCommand beerTypeCommand = new BeerTypeCommand();
        beerTypeCommand.setId(beerType.getId());
        beerTypeCommand.setDescription(beerType.getDescription());
        return beerTypeCommand;
    }
}
