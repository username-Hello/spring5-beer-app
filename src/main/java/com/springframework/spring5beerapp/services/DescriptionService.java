package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.DescriptionCommand;
import javassist.NotFoundException;

import java.util.List;

public interface DescriptionService {

    List<DescriptionCommand> getAll();

    DescriptionCommand findById(Long id) throws NotFoundException;

    DescriptionCommand save(DescriptionCommand description);

    void deleteById(Long id);
}
