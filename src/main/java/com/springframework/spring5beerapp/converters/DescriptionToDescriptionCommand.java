package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.DescriptionCommand;
import com.springframework.spring5beerapp.domain.Description;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DescriptionToDescriptionCommand implements Converter<Description, DescriptionCommand> {

    @Override
    public DescriptionCommand convert(Description description) {
        DescriptionCommand descriptionCommand = new DescriptionCommand();
        descriptionCommand.setId(description.getId());
        descriptionCommand.setText(description.getText());
        return descriptionCommand;
    }
}
