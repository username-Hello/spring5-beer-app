package com.springframework.spring5beerapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @OneToOne
    private Beer beer;
}
