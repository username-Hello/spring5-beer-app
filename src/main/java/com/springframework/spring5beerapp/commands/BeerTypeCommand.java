package com.springframework.spring5beerapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BeerTypeCommand {
    private Long id;
    private String description;
}
