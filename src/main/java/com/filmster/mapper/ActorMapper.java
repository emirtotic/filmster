package com.filmster.mapper;

import com.filmster.dto.ActorDTO;
import com.filmster.entity.Actor;
import com.filmster.mapper.decorator.ActorMapperDecorator;
import com.filmster.mapper.decorator.GenreMapperDecorator;
import com.filmster.service.data.ActorData;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
@DecoratedWith(ActorMapperDecorator.class)
public interface ActorMapper {

    Actor mapToEntity(ActorDTO actorDTO);
    ActorDTO mapToDto(Actor actor);
    List<Actor> mapToActorList(List<ActorDTO> actorDTOS);
    List<ActorDTO> mapToActorDTOList(List<Actor> actors);
    List<Actor> mapActors(List<Integer> actors);
    Actor mapActor(Integer actor);
    Actor mapDataToEntity(ActorData actorData);
}
