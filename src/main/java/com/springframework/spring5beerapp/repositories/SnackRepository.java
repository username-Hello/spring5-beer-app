package com.springframework.spring5beerapp.repositories;

import com.springframework.spring5beerapp.domain.Snack;
import org.springframework.data.repository.CrudRepository;

public interface SnackRepository extends CrudRepository<Snack, Long> {
}
