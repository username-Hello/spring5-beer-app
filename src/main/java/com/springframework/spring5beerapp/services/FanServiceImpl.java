package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.domain.Fan;
import com.springframework.spring5beerapp.repositories.FanRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FanServiceImpl implements FanService {

    private final FanRepository fanRepository;

    public FanServiceImpl(FanRepository fanRepository) {
        this.fanRepository = fanRepository;
    }

    @Override
    public List<Fan> getAll() {
        List<Fan> fans = new ArrayList<>();
        fanRepository.findAll().iterator().forEachRemaining(fans::add);
        return fans ;
    }

    @Override
    public Fan findById(Long id) throws NotFoundException {
        Optional<Fan> fanOptional = fanRepository.findById(id);
        if (fanOptional.isEmpty()){
            throw new NotFoundException("Fan doesn't exist");
        }
        return fanOptional.get();
    }

    @Override
    public Fan save(Fan fan) {
        return fanRepository.save(fan);
    }

    @Override
    public void deleteById(Long id) {
        fanRepository.deleteById(id);
    }
}
