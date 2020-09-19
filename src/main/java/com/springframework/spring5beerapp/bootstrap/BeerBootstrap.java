package com.springframework.spring5beerapp.bootstrap;

import com.springframework.spring5beerapp.domain.*;
import com.springframework.spring5beerapp.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class BeerBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final BeerTypeRepository beerTypeRepository;
    private final DescriptionRepository descriptionRepository;
    private final ReviewRepository reviewRepository;
    private final FanRepository fanRepository;
    private final BeerRepository beerRepository;
    private final SnackRepository snackRepository;

    public BeerBootstrap(BeerTypeRepository beerTypeRepository, DescriptionRepository descriptionRepository,
                         ReviewRepository reviewRepository, FanRepository fanRepository, BeerRepository beerRepository,
                         SnackRepository snackRepository) {
        this.beerTypeRepository = beerTypeRepository;
        this.descriptionRepository = descriptionRepository;
        this.reviewRepository = reviewRepository;
        this.fanRepository = fanRepository;
        this.beerRepository = beerRepository;
        this.snackRepository = snackRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        beerRepository.saveAll(getBeer());
    }

    private List<Beer> getBeer() {
        List<Beer> beerArrayList = new ArrayList<>();

        // create Beer types
        BeerType amberBeerType = new BeerType();
        amberBeerType.setDescription("Amber");
        beerTypeRepository.save(amberBeerType);

        BeerType lightBeerType = new BeerType();
        lightBeerType.setDescription("Light");
        beerTypeRepository.save(lightBeerType);

        BeerType darkBeerType = new BeerType();
        darkBeerType.setDescription("Dark");
        beerTypeRepository.save(darkBeerType);

        // create descriptions
        Description description1 = new Description();
        description1.setText("it is a light lager with a light traditional flavor. The beer is brewed according to " +
                "the original recipe with the addition of the famous Czech aromatic hops of the Zatecky variety. Its " +
                "use gives the beer a special aroma and light bitterness, while it is easy to drink");
        descriptionRepository.save(description1);

        Description description2 = new Description();
        description2.setText("It's not a very good beer. Drink it at its worst. :(");
        descriptionRepository.save(description2);

        // create reviews
        Review goodReview = new Review();
        goodReview.setText("It's a really good beer. You have to try this. :)");
        reviewRepository.save(goodReview);

        Review badReview = new Review();
        badReview.setText("It's not a very good beer. Drink it at its worst. :(");
        reviewRepository.save(badReview);

        Review excellentReview = new Review();
        excellentReview.setText("It's the best beer you've ever drank. Of course try this");
        reviewRepository.save(excellentReview);

        // create fans
        Fan fanSam = new Fan();
        fanSam.setFirstName("Sam");
        fanSam.setLastName("Mas");
        fanSam.setReview(goodReview);
        fanSam.setSex(Sex.MALE);
        fanRepository.save(fanSam);

        Fan fanFiona = new Fan();
        fanFiona.setFirstName("Fiona");
        fanFiona.setLastName("Green");
        fanFiona.setSex(Sex.FEMALE);
        fanFiona.setReview(badReview);
        fanRepository.save(fanFiona);

        Fan fanMonica = new Fan();
        fanMonica.setFirstName("Monica");
        fanMonica.setLastName("Geller");
        fanMonica.setSex(Sex.FEMALE);
        fanMonica.setReview(excellentReview);
        fanRepository.save(fanMonica);

        // create snacks
        Snack crisps = new Snack();
        crisps.setDescription("Crisps");
        crisps.setType(SnackType.LIGHT);
        snackRepository.save(crisps);

        Snack fish = new Snack();
        fish.setDescription("Dried fish");
        fish.setType(SnackType.MEDIUM);
        snackRepository.save(fish);

        // create beers
        Beer zhatetskyGoose = new Beer();
        zhatetskyGoose.setName("Zhatetsky Goose");
        zhatetskyGoose.setDescription(description1);
        zhatetskyGoose.setBeerType(lightBeerType);
        zhatetskyGoose.addFan(fanSam);
        zhatetskyGoose.addFan(fanFiona);
        zhatetskyGoose.addReview(goodReview);
        zhatetskyGoose.addReview(excellentReview);
        zhatetskyGoose.setSnack(crisps);
        zhatetskyGoose.addIngredient(new Ingredient("Alcohol"));
        zhatetskyGoose.addIngredient(new Ingredient("Water"));
        zhatetskyGoose.addIngredient(new Ingredient("Piece of Goose"));

        Beer alivariaWhiteGold = new Beer();
        alivariaWhiteGold.setName("Alivaria White Gold");
        alivariaWhiteGold.setDescription(description2);
        alivariaWhiteGold.setBeerType(lightBeerType);
        alivariaWhiteGold.addFan(fanMonica);
        alivariaWhiteGold.addFan(fanSam);
        alivariaWhiteGold.addReview(badReview);
        alivariaWhiteGold.setSnack(fish);
        alivariaWhiteGold.addIngredient(new Ingredient("Gold Alcohol"));
        alivariaWhiteGold.addIngredient(new Ingredient("Gold Water"));
        alivariaWhiteGold.addIngredient(new Ingredient("Just gold"));

        beerArrayList.add(zhatetskyGoose);
        beerArrayList.add(alivariaWhiteGold);
        return beerArrayList;
    }
}
