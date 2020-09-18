package com.springframework.spring5beerapp.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Description description;

    @ManyToOne
    private BeerType beerType;

    @ManyToMany
    @JoinTable(name = "beer_fan",
            joinColumns = @JoinColumn(name = "beer_id"),
            inverseJoinColumns = @JoinColumn(name = "fan_id"))
    private List<Fan> fans = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beer")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beer")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void setBeerType(BeerType beerType){
        beerType.getBeer().add(this);
        this.beerType = beerType;    }

}
