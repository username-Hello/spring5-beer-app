package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.SnackCommand;
import com.springframework.spring5beerapp.domain.Snack;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SnackToSnackCommand implements Converter<Snack, SnackCommand> {

    @Override
    public SnackCommand convert(Snack snack) {
        SnackCommand snackCommand = new SnackCommand();
        snackCommand.setId(snack.getId());
        snackCommand.setDescription(snack.getDescription());
        snackCommand.setType(snack.getType());
        return snackCommand;
    }
}
