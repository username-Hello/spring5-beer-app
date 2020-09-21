package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.ReviewCommand;
import javassist.NotFoundException;

import java.util.List;

public interface ReviewService {

    List<ReviewCommand> getAll();

    ReviewCommand findById(Long id) throws NotFoundException;

    ReviewCommand save(ReviewCommand reviewCommand);

    void deleteById(Long id);
}
