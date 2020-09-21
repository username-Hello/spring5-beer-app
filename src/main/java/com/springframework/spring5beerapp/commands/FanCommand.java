package com.springframework.spring5beerapp.commands;

import com.springframework.spring5beerapp.domain.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FanCommand {

    private Long id;
    private Sex sex;
    private String firstName;
    private String lastName;
}
