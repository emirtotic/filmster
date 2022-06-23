package com.filmster.service.impl;

import com.filmster.dto.ActorDTO;
import com.filmster.entity.Actor;
import com.filmster.exception.ActorNotFound;
import com.filmster.mapper.ActorMapper;
import com.filmster.repository.ActorRepository;
import com.filmster.service.ActorService;
import com.filmster.service.data.ActorData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    /**
     * Finding all actors in DB
     * @return List<ActorDTO>
     */
    @Override
    public List<ActorDTO> findAllActors() {
        return actorMapper.mapToActorDTOList(actorRepository.findAll());
    }

    /**
     * Find an Actor by id
     * @param id
     * @return ActorDTO object
     */
    @Override
    public ActorDTO findActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new ActorNotFound(id));
        return actorMapper.mapToDto(actor);
    }

    /**
     * Delete an Actor by id
     * @param id
     */
    @Override
    public void deleteActorById(Long id) {
        actorRepository.findById(id).orElseThrow(() -> new ActorNotFound(id));
        actorRepository.deleteById(id);
    }

    /**
     * Create an Actor
     * @param actorData
     * @return ActorDTO object
     */
    @Override
    @Transactional
    public ActorDTO createActor(ActorData actorData) {
        Actor actor = actorMapper.mapDataToEntity(actorData);
        return actorMapper.mapToDto(actorRepository.save(actor));
    }

    /**
     * Update an Actor
     * @param id
     * @param actorData
     * @return ActorDTO object
     */
    @Override
    public ActorDTO updateActor(Long id, ActorData actorData) {
        Actor actorFromDb = actorRepository.findById(id).orElseThrow(() -> new ActorNotFound(id));

        actorFromDb.setId(id);
        actorFromDb.setFirstName(actorData.getFirstName());
        actorFromDb.setLastName(actorData.getLastName());
        actorFromDb.setDateOfBirth(actorData.getDateOfBirth());
        actorFromDb.setAge(Integer.valueOf(LocalDate.now().getYear() - actorData.getDateOfBirth().getYear()));
        actorFromDb.setGender(actorData.getGender());

        return actorMapper.mapToDto(actorRepository.save(actorFromDb));
    }

    /**
     * Finding all Male Actors from DB
     *
     * @return List<ActorDTO> with all Male actors
     */
    @Override
    public List<ActorDTO> findAllMaleActors() {
        return actorMapper.mapToActorDTOList(actorRepository.findAllMaleActors());
    }

    /**
     * Finding all Actress from DB
     *
     * @return List<ActorDTO> with all Actress
     */
    @Override
    public List<ActorDTO> findAllActress() {
        return actorMapper.mapToActorDTOList(actorRepository.findAllActress());
    }
}
