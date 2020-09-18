package com.springframework.spring5beerapp.repositories;

import com.springframework.spring5beerapp.domain.Description;
import org.springframework.data.repository.CrudRepository;

public interface DescriptionRepository extends CrudRepository<Description, Long> {
}
