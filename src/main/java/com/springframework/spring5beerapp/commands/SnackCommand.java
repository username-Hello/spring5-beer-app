package com.springframework.spring5beerapp.commands;

import com.springframework.spring5beerapp.domain.SnackType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SnackCommand {

    private Long id;
    private String description;
    private SnackType type;
}
