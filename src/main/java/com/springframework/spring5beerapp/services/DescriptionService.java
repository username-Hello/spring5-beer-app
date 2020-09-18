package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Description;
import javassist.NotFoundException;

import java.util.List;

public interface DescriptionService {

    List<Description> getAll();

    Description findById(Long id) throws NotFoundException;

    Description save(Description description);

    void deleteById(Long id);
}
