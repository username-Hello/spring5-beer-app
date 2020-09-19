package com.springframework.spring5beerapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class BeerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;

    @OneToMany(mappedBy = "beerType")
    private List<Beer> beer = new ArrayList<>();
}
