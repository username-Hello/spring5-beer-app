package com.springframework.spring5beerapp.bootstrap;

import com.springframework.spring5beerapp.domain.Beer;
import com.springframework.spring5beerapp.domain.BeerType;
import com.springframework.spring5beerapp.domain.Description;
import com.springframework.spring5beerapp.repositories.BeerTypeRepository;
import com.springframework.spring5beerapp.repositories.DescriptionRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class BeerBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final BeerTypeRepository beerTypeRepository;
    private  final DescriptionRepository descriptionRepository;

    public BeerBootstrap(BeerTypeRepository beerTypeRepository, DescriptionRepository descriptionRepository) {
        this.beerTypeRepository = beerTypeRepository;
        this.descriptionRepository = descriptionRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        getBeer();
    }

    private List<Beer> getBeer(){
        List<Beer> beerArrayList = new ArrayList<>();

        // create Beer types
        BeerType amberBeerType = new BeerType();
        amberBeerType.setDescription("Amber");
        BeerType amberBeerTypeSaved = beerTypeRepository.save(amberBeerType);

        BeerType lightBeerType = new BeerType();
        lightBeerType.setDescription("Light");
        BeerType lightBeerTypeSaved = beerTypeRepository.save(lightBeerType);

        BeerType darkBeerType = new BeerType();
        darkBeerType.setDescription("Dark");
        BeerType darkBeerTypeSaved = beerTypeRepository.save(darkBeerType);

        // create description
        Description goodDescription = new Description();
        goodDescription.setText("It's a really good beer. You have to try this. :)");
        descriptionRepository.save(goodDescription);


        return null;
    }
}
