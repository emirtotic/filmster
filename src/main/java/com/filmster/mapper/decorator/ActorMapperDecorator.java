package com.filmster.mapper.decorator;

import com.filmster.dto.ActorDTO;
import com.filmster.entity.Actor;
import com.filmster.mapper.ActorMapper;
import com.filmster.repository.ActorRepository;
import com.filmster.service.data.ActorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDate;

public abstract class ActorMapperDecorator implements ActorMapper{

    @Autowired
    @Qualifier("delegate")
    private ActorMapper actorMapper;

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor mapDataToEntity(ActorData actorData) {
        Actor actor = actorMapper.mapDataToEntity(actorData);
        actor.setAge(Integer.valueOf(LocalDate.now().getYear() - actorData.getDateOfBirth().getYear()));
        return actor;
    }

    @Override
    public ActorDTO mapToDto(Actor actor) {
        ActorDTO actorDTO = actorMapper.mapToDto(actor);
        actorDTO.setAge(Integer.valueOf(LocalDate.now().getYear() - actor.getDateOfBirth().getYear()));
        return actorDTO;
    }
}
