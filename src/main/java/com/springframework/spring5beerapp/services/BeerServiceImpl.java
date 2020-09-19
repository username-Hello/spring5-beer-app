package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Beer;
import com.springframework.spring5beerapp.repositories.*;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerTypeRepository beerTypeRepository;
    private final DescriptionRepository descriptionRepository;
    private final FanRepository fanRepository;
    private final ReviewRepository reviewRepository;
    private final IngredientRepository ingredientRepository;
    private final SnackRepository snackRepository;

    public BeerServiceImpl(BeerRepository beerRepository, BeerTypeRepository beerTypeRepository,
                           DescriptionRepository descriptionRepository, FanRepository fanRepository,
                           ReviewRepository reviewRepository, IngredientRepository ingredientRepository,
                           SnackRepository snackRepository) {
        this.beerRepository = beerRepository;
        this.beerTypeRepository = beerTypeRepository;
        this.descriptionRepository = descriptionRepository;
        this.fanRepository = fanRepository;
        this.reviewRepository = reviewRepository;
        this.ingredientRepository = ingredientRepository;
        this.snackRepository = snackRepository;
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

        // Проверки, сохранены ли компоненты объекта Beer в БД
        if (beerTypeRepository.findById(beer.getBeerType().getId()).isEmpty()) {
            beerTypeRepository.save(beer.getBeerType());
        }
        if (descriptionRepository.findById(beer.getDescription().getId()).isEmpty()) {
            descriptionRepository.save(beer.getDescription());
        }
        beer.getFans().forEach(fan -> {
            if (fanRepository.findById(fan.getId()).isEmpty()) {
                fanRepository.save(fan);
            }
        });
        beer.getReviews().forEach(review -> {
            if (reviewRepository.findById(review.getId()).isEmpty()) {
                reviewRepository.save(review);
            }
        });
        beer.getIngredients().forEach(ingredient -> {
            if (ingredientRepository.findById(ingredient.getId()).isEmpty()) {
                ingredientRepository.save(ingredient);
            }
        });
        if (snackRepository.findById(beer.getSnack().getId()).isEmpty()){
            snackRepository.save(beer.getSnack());
        }
        return beerRepository.save(beer);
    }

    @Override
    public void deleteById(Long id) {
        beerRepository.deleteById(id);
    }
}
