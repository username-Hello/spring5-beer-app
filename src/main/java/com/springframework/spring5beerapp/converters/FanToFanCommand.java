package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.FanCommand;
import com.springframework.spring5beerapp.domain.Fan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FanToFanCommand implements Converter<Fan, FanCommand> {
    @Override
    public FanCommand convert(Fan fan) {
        FanCommand fanCommand = new FanCommand();
        fanCommand.setId(fan.getId());
        fanCommand.setFirstName(fan.getFirstName());
        fanCommand.setLastName(fan.getLastName());
        return fanCommand;
    }
}
