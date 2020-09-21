package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.FanCommand;
import javassist.NotFoundException;

import java.util.List;

public interface FanService {

    List<FanCommand> getAll();

    FanCommand findById(Long id) throws NotFoundException;

    FanCommand save(FanCommand fan);

    void deleteById(Long id);
}
