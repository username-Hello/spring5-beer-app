package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Review;
import javassist.NotFoundException;

import java.util.List;

public interface ReviewService {

    List<Review> getAll();

    Review findById(Long id) throws NotFoundException;

    Review save(Review review);

    void deleteById(Long id);
}
