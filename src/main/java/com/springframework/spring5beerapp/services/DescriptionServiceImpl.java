package com.springframework.spring5beerapp.services;

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

    public DescriptionServiceImpl(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    @Override
    public List<Description> getAll() {
        List<Description> descriptions = new ArrayList<>();
        descriptionRepository.findAll().iterator().forEachRemaining(descriptions::add);
        return descriptions;
    }

    @Override
    public Description findById(Long id) throws NotFoundException {
        Optional<Description> descriptionOptional = descriptionRepository.findById(id);
        if (descriptionOptional.isEmpty()) {
            throw new NotFoundException("Description doesn't exist");
        }
        return descriptionOptional.get();
    }

    @Override
    public Description save(Description description) {
        return descriptionRepository.save(description);
    }

    @Override
    public void deleteById(Long id) {
        descriptionRepository.deleteById(id);
    }
}
