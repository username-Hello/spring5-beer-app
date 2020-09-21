package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.BeerCommand;
import com.springframework.spring5beerapp.converters.BeerCommandToBeer;
import com.springframework.spring5beerapp.converters.BeerToBeerCommand;
import com.springframework.spring5beerapp.domain.Beer;
import com.springframework.spring5beerapp.repositories.BeerRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerToBeerCommand beerToBeerCommand;
    private final BeerCommandToBeer beerCommandToBeer;

    public BeerServiceImpl(BeerRepository beerRepository,
                           BeerToBeerCommand beerToBeerCommand,
                           BeerCommandToBeer beerCommandToBeer) {
        this.beerRepository = beerRepository;
        this.beerToBeerCommand = beerToBeerCommand;
        this.beerCommandToBeer = beerCommandToBeer;
    }

    @Override
    public List<BeerCommand> getAll() {
        List<BeerCommand> beers = new ArrayList<>();
        beerRepository
                .findAll()
                .iterator()
                .forEachRemaining(beer -> beers.add(beerToBeerCommand.convert(beer)));
        return beers;
    }

    @Override
    public BeerCommand findById(Long id) throws NotFoundException {
        Optional<Beer> beerOptional = beerRepository.findById(id);
        if (beerOptional.isEmpty()) {
            throw new NotFoundException("Beer doesn't exist");
        }
        return beerToBeerCommand.convert(beerOptional.get());
    }

    @Override
    public BeerCommand findByName(String name) throws NotFoundException {
        Optional<Beer> beerOptional = beerRepository.findBeerByName(name);
        if (beerOptional.isEmpty()) {
            throw new NotFoundException("Beer doesn't exist");
        }
        return beerToBeerCommand.convert(beerOptional.get());
    }

    @Override
    public BeerCommand save(BeerCommand beerCommand) {
        return beerToBeerCommand.convert(beerRepository.save(beerCommandToBeer.convert(beerCommand)));
    }

    @Override
    public BeerCommand update(BeerCommand beerCommand) throws NotFoundException {
        Beer beer = beerCommandToBeer.convert(beerCommand);
        beer.getIngredients().forEach(ingredient -> ingredient.setBeer(beer));
        beer.getReviews().forEach(review -> review.setBeer(beer));

        return beerToBeerCommand.convert(beerRepository.save(beer));
    }

    @Override
    public void deleteById(Long id) {
        beerRepository.deleteById(id);
    }
}
