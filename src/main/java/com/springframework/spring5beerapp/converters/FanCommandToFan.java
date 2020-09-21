package com.springframework.spring5beerapp.converters;

import com.springframework.spring5beerapp.commands.FanCommand;
import com.springframework.spring5beerapp.domain.Fan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FanCommandToFan implements Converter<FanCommand, Fan> {

    @Override
    public Fan convert(FanCommand fanCommand) {
        Fan fan = new Fan();
        fan.setId(fanCommand.getId());
        fan.setSex(fanCommand.getSex());
        fan.setFirstName(fanCommand.getFirstName());
        fan.setLastName(fanCommand.getLastName());
        return fan;
    }
}
