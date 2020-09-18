package com.springframework.spring5beerapp.repositories;

import com.springframework.spring5beerapp.domain.Fan;
import org.springframework.data.repository.CrudRepository;

public interface FanRepository extends CrudRepository<Fan, Long> {
}
