package com.springframework.spring5beerapp.repositories;

import com.springframework.spring5beerapp.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
