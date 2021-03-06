package com.springframework.spring5beerapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne
    private Beer beer;

    public Ingredient(String description) {
        this.description = description;
    }

    public Ingredient() {

    }
}
