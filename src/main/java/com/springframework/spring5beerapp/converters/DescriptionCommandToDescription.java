package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.DescriptionCommand;
import com.springframework.spring5beerapp.domain.Description;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DescriptionCommandToDescription implements Converter<DescriptionCommand, Description> {
    @Override
    public Description convert(DescriptionCommand descriptionCommand) {
        Description description = new Description();
        description.setId(descriptionCommand.getId());
        description.setText(descriptionCommand.getText());
        return description;
    }
}
