package com.springframework.spring5beerapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Fan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Sex sex;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "fans")
    private List<Beer> beer = new ArrayList<>();

    @OneToOne()
    private Review review;
}
