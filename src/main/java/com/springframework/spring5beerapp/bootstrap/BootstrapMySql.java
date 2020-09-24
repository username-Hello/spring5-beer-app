package com.springframework.spring5beerapp.bootstrap;

import com.springframework.spring5beerapp.domain.*;
import com.springframework.spring5beerapp.repositories.BeerTypeRepository;
import com.springframework.spring5beerapp.repositories.FanRepository;
import com.springframework.spring5beerapp.repositories.SnackRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("dev")
public class BootstrapMySql implements ApplicationListener<ContextRefreshedEvent> {

    private final BeerTypeRepository beerTypeRepository;
    private final FanRepository fanRepository;
    private final SnackRepository snackRepository;

    public BootstrapMySql(BeerTypeRepository beerType, FanRepository fanRepository, SnackRepository snackRepository) {
        this.beerTypeRepository = beerType;
        this.fanRepository = fanRepository;
        this.snackRepository = snackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (beerTypeRepository.count() == 0L){
            beerTypeRepository.saveAll(getBeerTypes());
        }
        if (fanRepository.count() == 0L) {
            fanRepository.saveAll(getFans());
        }
        if (snackRepository.count() == 0L) {
            snackRepository.saveAll(getSnacks());
        }
    }

    private List<BeerType> getBeerTypes(){
        BeerType amberBeerType = new BeerType();
        amberBeerType.setDescription("Amber");

        BeerType lightBeerType = new BeerType();
        lightBeerType.setDescription("Light");

        BeerType darkBeerType = new BeerType();
        darkBeerType.setDescription("Dark");

        return Arrays.asList(amberBeerType, lightBeerType, darkBeerType);
    }

    private List<Fan> getFans() {
        Fan fanSam = new Fan();
        fanSam.setFirstName("Sam");
        fanSam.setLastName("Mas");
        fanSam.setSex(Sex.MALE);

        Fan fanFiona = new Fan();
        fanFiona.setFirstName("Fiona");
        fanFiona.setLastName("Green");
        fanFiona.setSex(Sex.FEMALE);

        Fan fanMonica = new Fan();
        fanMonica.setFirstName("Monica");
        fanMonica.setLastName("Geller");
        fanMonica.setSex(Sex.FEMALE);

        return Arrays.asList(fanSam, fanFiona, fanMonica);
    }

    private List<Snack> getSnacks() {
        Snack crisps = new Snack();
        crisps.setDescription("Crisps");
        crisps.setType(SnackType.LIGHT);

        Snack fish = new Snack();
        fish.setDescription("Dried fish");
        fish.setType(SnackType.MEDIUM);

        return Arrays.asList(crisps, fish);
    }
}
