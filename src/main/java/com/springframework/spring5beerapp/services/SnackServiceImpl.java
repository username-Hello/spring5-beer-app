package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.SnackCommand;
import com.springframework.spring5beerapp.converters.SnackCommandToSnack;
import com.springframework.spring5beerapp.converters.SnackToSnackCommand;
import com.springframework.spring5beerapp.domain.Snack;
import com.springframework.spring5beerapp.repositories.SnackRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SnackServiceImpl implements SnackService {

    private final SnackRepository snackRepository;
    private final SnackToSnackCommand snackToSnackCommand;
    private final SnackCommandToSnack snackCommandToSnack;

    public SnackServiceImpl(SnackRepository snackRepository, SnackToSnackCommand snackToSnackCommand, SnackCommandToSnack snackCommandToSnack) {
        this.snackRepository = snackRepository;
        this.snackToSnackCommand = snackToSnackCommand;
        this.snackCommandToSnack = snackCommandToSnack;
    }

    @Override
    public List<SnackCommand> getAll() {
        List<SnackCommand> snackCommands = new ArrayList<>();
        snackRepository
                .findAll()
                .iterator()
                .forEachRemaining(snack -> snackCommands.add(snackToSnackCommand.convert(snack)));
        return snackCommands;
    }

    @Override
    public SnackCommand findById(Long id) throws NotFoundException {
        Optional<Snack> snackOptional = snackRepository.findById(id);
        if (snackOptional.isEmpty()) {
            throw new NotFoundException("Snack doesn't exist");
        }
        return snackToSnackCommand.convert(snackOptional.get());
    }

    @Override
    public SnackCommand save(SnackCommand snackCommand) {
        return snackToSnackCommand
                .convert(snackRepository
                        .save(snackCommandToSnack.convert((snackCommand))));
    }

    @Override
    public void deleteById(Long id) {
        snackRepository.deleteById(id);
    }
}
