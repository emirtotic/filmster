package com.filmster.service;

import com.filmster.dto.ActorDTO;
import com.filmster.service.data.ActorData;

import java.util.List;

public interface ActorService {

    /**
     * Finding all actors in DB
     * @return List<ActorDTO>
     */
    List<ActorDTO> findAllActors();

    /**
     * Find an Actor by id
     * @param id
     * @return ActorDTO object
     */
    ActorDTO findActorById(Long id);

    /**
     * Delete an Actor by id
     * @param id
     */
    void deleteActorById(Long id);

    /**
     * Create an Actor
     * @param actorData
     * @return ActorDTO object
     */
    ActorDTO createActor(ActorData actorData);

    /**
     * Update an Actor
     * @param id
     * @param actorData
     * @return ActorDTO object
     */
    ActorDTO updateActor(Long id, ActorData actorData);

    /**
     * Finding all Male Actors from DB
     * @return List<ActorDTO> with all Male actors
     */
    List<ActorDTO> findAllMaleActors();

    /**
     * Finding all Actresses from DB
     * @return List<ActorDTO> with all Actresses
     */
    List<ActorDTO> findAllActresses();
}
