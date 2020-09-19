package com.springframework.spring5beerapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String text;

    @ManyToOne()
    private Beer beer;

    @OneToOne
    private Fan fan;
}
