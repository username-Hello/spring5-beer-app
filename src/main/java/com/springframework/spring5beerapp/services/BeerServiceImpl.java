package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Beer;
import com.springframework.spring5beerapp.repositories.BeerRepository;
import com.springframework.spring5beerapp.repositories.BeerTypeRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerTypeRepository beerTypeRepository;

    public BeerServiceImpl(BeerRepository beerRepository, BeerTypeRepository beerTypeRepository) {
        this.beerRepository = beerRepository;
        this.beerTypeRepository = beerTypeRepository;
    }

    @Override
    public List<Beer> getAll() {
        List<Beer> beers = new ArrayList<>();
        beerRepository.findAll().iterator().forEachRemaining(beers::add);
        return beers;
    }

    @Override
    public Beer findById(Long id) throws NotFoundException {
        Optional<Beer> beerOptional = beerRepository.findById(id);
        if (beerOptional.isEmpty()) {
            throw new NotFoundException("Beer doesn't exist");
        }
        return beerOptional.get();
    }

    @Override
    public Beer findByName(String name) throws NotFoundException {
        Optional<Beer> beerOptional = beerRepository.findBeerByName(name);
        if (beerOptional.isEmpty()) {
            throw new NotFoundException("Beer doesn't exist");
        }
        return beerOptional.get();
    }

    @Override
    public Beer save(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public void deleteById(Long id) {
        beerRepository.deleteById(id);
    }
}
