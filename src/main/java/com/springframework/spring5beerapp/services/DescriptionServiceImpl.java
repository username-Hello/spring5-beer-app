package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.DescriptionCommand;
import com.springframework.spring5beerapp.converters.DescriptionCommandToDescription;
import com.springframework.spring5beerapp.converters.DescriptionToDescriptionCommand;
import com.springframework.spring5beerapp.domain.Description;
import com.springframework.spring5beerapp.repositories.DescriptionRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DescriptionServiceImpl implements DescriptionService {

    private final DescriptionRepository descriptionRepository;
    private final DescriptionToDescriptionCommand descriptionToDescriptionCommand;
    private final DescriptionCommandToDescription descriptionCommandToDescription;

    public DescriptionServiceImpl(DescriptionRepository descriptionRepository,
                                  DescriptionToDescriptionCommand descriptionToDescriptionCommand,
                                  DescriptionCommandToDescription descriptionCommandToDescription) {
        this.descriptionRepository = descriptionRepository;
        this.descriptionToDescriptionCommand = descriptionToDescriptionCommand;
        this.descriptionCommandToDescription = descriptionCommandToDescription;
    }

    @Override
    public List<DescriptionCommand> getAll() {
        List<DescriptionCommand> descriptionCommands = new ArrayList<>();
        descriptionRepository
                .findAll()
                .iterator()
                .forEachRemaining(description -> descriptionCommands
                        .add(descriptionToDescriptionCommand.convert(description)));
        return descriptionCommands;
    }

    @Override
    public DescriptionCommand findById(Long id) throws NotFoundException {
        Optional<Description> descriptionOptional = descriptionRepository.findById(id);
        if (descriptionOptional.isEmpty()) {
            throw new NotFoundException("Description doesn't exist");
        }
        return descriptionToDescriptionCommand.convert(descriptionOptional.get());
    }

    @Override
    public DescriptionCommand save(DescriptionCommand descriptionCommand) {
        return descriptionToDescriptionCommand
                .convert(descriptionRepository
                        .save(descriptionCommandToDescription.convert(descriptionCommand)));
    }

    @Override
    public void deleteById(Long id) {
        descriptionRepository.deleteById(id);
    }
}
