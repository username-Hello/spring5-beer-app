package com.springframework.spring5beerapp.services;

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

    public BeerTypeServiceImpl(BeerTypeRepository beerTypeRepository) {
        this.beerTypeRepository = beerTypeRepository;
    }

    @Override
    public List<BeerType> getAll() {
        List<BeerType> beerTypes = new ArrayList<>();
        beerTypeRepository.findAll().iterator().forEachRemaining(beerTypes::add);
        return beerTypes;
    }

    @Override
    public BeerType findById(Long id) throws NotFoundException {
        Optional<BeerType> beerTypeOptional = beerTypeRepository.findById(id);
        if (beerTypeOptional.isEmpty()){
            throw new NotFoundException("Beer type doesn't exist");
        }
        return beerTypeOptional.get();
    }

    @Override
    public BeerType save(BeerType beerType) {
        return beerTypeRepository.save(beerType);
    }

    @Override
    public void deleteById(Long id) {
        beerTypeRepository.deleteById(id);
    }
}
