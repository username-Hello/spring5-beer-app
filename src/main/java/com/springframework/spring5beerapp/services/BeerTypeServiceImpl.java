package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.BeerTypeCommand;
import com.springframework.spring5beerapp.converters.BeerTypeCommandToBeerType;
import com.springframework.spring5beerapp.converters.BeerTypeToBeerTypeCommand;
import com.springframework.spring5beerapp.domain.BeerType;
import com.springframework.spring5beerapp.repositories.BeerTypeRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeerTypeServiceImpl implements BeerTypeService {

    private final BeerTypeRepository beerTypeRepository;
    private final BeerTypeCommandToBeerType beerTypeCommandToBeerType;
    private final BeerTypeToBeerTypeCommand beerTypeToBeerTypeCommand;

    public BeerTypeServiceImpl(BeerTypeRepository beerTypeRepository,
                               BeerTypeCommandToBeerType beerTypeCommandToBeerType,
                               BeerTypeToBeerTypeCommand beerTypeToBeerTypeCommand) {
        this.beerTypeRepository = beerTypeRepository;
        this.beerTypeCommandToBeerType = beerTypeCommandToBeerType;
        this.beerTypeToBeerTypeCommand = beerTypeToBeerTypeCommand;
    }

    @Override
    public List<BeerTypeCommand> getAll() {
        List<BeerTypeCommand> beerTypes = new ArrayList<>();
        beerTypeRepository
                .findAll()
                .iterator()
                .forEachRemaining(beerType ->beerTypes.add(beerTypeToBeerTypeCommand.convert(beerType)));
        return beerTypes;
    }

    @Override
    public BeerTypeCommand findById(Long id) throws NotFoundException {
        Optional<BeerType> beerTypeOptional = beerTypeRepository.findById(id);
        if (beerTypeOptional.isEmpty()){
            throw new NotFoundException("Beer type doesn't exist");
        }
        return beerTypeToBeerTypeCommand.convert(beerTypeOptional.get());
    }

    @Override
    public BeerTypeCommand save(BeerTypeCommand beerType) {
        return beerTypeToBeerTypeCommand
                .convert(beerTypeRepository
                        .save(beerTypeCommandToBeerType.convert(beerType)));
    }

    @Override
    public void deleteById(Long id) {
        beerTypeRepository.deleteById(id);
    }
}
