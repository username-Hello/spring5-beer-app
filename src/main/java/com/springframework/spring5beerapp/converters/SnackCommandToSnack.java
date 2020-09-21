package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.SnackCommand;
import com.springframework.spring5beerapp.domain.Snack;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SnackCommandToSnack implements Converter<SnackCommand, Snack> {

    @Override
    public Snack convert(SnackCommand snackCommand) {
        Snack snack = new Snack();
        snack.setId(snackCommand.getId());
        snack.setDescription(snackCommand.getDescription());
        snack.setType(snackCommand.getType());
        return snack;
    }
}
