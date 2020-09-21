package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.SnackCommand;
import javassist.NotFoundException;

import java.util.List;

public interface SnackService {

    List<SnackCommand> getAll();

    SnackCommand findById(Long id) throws NotFoundException;

    SnackCommand save(SnackCommand snackCommand);

    void deleteById(Long id);
}
