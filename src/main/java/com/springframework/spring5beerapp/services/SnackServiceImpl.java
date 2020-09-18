package com.springframework.spring5beerapp.services;

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

    public SnackServiceImpl(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    @Override
    public List<Snack> getAll() {
        List<Snack> snacks = new ArrayList<>();
        snackRepository.findAll().iterator().forEachRemaining(snacks::add);
        return snacks;
    }

    @Override
    public Snack findById(Long id) throws NotFoundException {
        Optional<Snack> snackOptional = snackRepository.findById(id);
        if (snackOptional.isEmpty()){
            throw new NotFoundException("Snack doesn't exist");
        }
        return snackOptional.get();
    }

    @Override
    public Snack save(Snack snack) {
        return snackRepository.save(snack);
    }

    @Override
    public void deleteById(Long id) {
        snackRepository.deleteById(id);
    }
}
