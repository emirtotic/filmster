package com.filmster.repository;

import com.filmster.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query(value = "SELECT * FROM Actor where gender = 'MALE'", nativeQuery = true)
    List<Actor> findAllMaleActors();

    @Query(value = "SELECT * FROM Actor where gender = 'FEMALE'", nativeQuery = true)
    List<Actor> findAllActress();

}
