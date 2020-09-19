package com.springframework.spring5beerapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    @OneToOne
    private Snack snack;


    public void setBeerType(BeerType beerType) {
        beerType.getBeer().add(this);
        this.beerType = beerType;
    }

    public void setDescription(Description description) {
        description.setBeer(this);
        this.description = description;
    }

    public void addFan(Fan fan) {
        fan.getBeer().add(this);
        this.fans.add(fan);
    }

    public void addReview(Review review) {
        review.setBeer(this);
        this.reviews.add(review);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredient.setBeer(this);
        this.ingredients.add(ingredient);
    }
}
