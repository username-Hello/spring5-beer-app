package com.springframework.spring5beerapp.services;

import com.springframework.spring5beerapp.commands.FanCommand;
import com.springframework.spring5beerapp.converters.FanCommandToFan;
import com.springframework.spring5beerapp.converters.FanToFanCommand;
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
    private final FanToFanCommand fanToFanCommand;
    private final FanCommandToFan fanCommandToFan;

    public FanServiceImpl(FanRepository fanRepository, FanToFanCommand fanToFanCommand, FanCommandToFan fanCommandToFan) {
        this.fanRepository = fanRepository;
        this.fanToFanCommand = fanToFanCommand;
        this.fanCommandToFan = fanCommandToFan;
    }

    @Override
    public List<FanCommand> getAll() {
        List<FanCommand> fanCommands = new ArrayList<>();
        fanRepository
                .findAll()
                .iterator()
                .forEachRemaining(fan -> fanCommands.add(fanToFanCommand.convert(fan)));
        return fanCommands;
    }

    @Override
    public FanCommand findById(Long id) throws NotFoundException {
        Optional<Fan> fanOptional = fanRepository.findById(id);
        if (fanOptional.isEmpty()){
            throw new NotFoundException("Fan doesn't exist");
        }
        return fanToFanCommand.convert(fanOptional.get());
    }

    @Override
    public FanCommand save(FanCommand fanCommand) {
        return fanToFanCommand
                .convert(fanRepository
                        .save(fanCommandToFan.convert(fanCommand)));
    }

    @Override
    public void deleteById(Long id) {
        fanRepository.deleteById(id);
    }
}
