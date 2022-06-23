package com.filmster.repository;

import com.filmster.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE lower(m.name) LIKE %:movieName%")
    List<Movie> findByNameContainingIgnoreCase(@Param("movieName") String movieName);

    @Query("SELECT m FROM Movie m WHERE m.year = :year")
    List<Movie> findAllMoviesByYear(@Param("year") int year);

    @Query("SELECT m FROM Movie m WHERE m.year < :year")
    List<Movie> findAllMoviesBeforeYear(@Param("year") int year);

    @Query("SELECT m FROM Movie m WHERE m.year > :year")
    List<Movie> findAllMoviesAfterYear(@Param("year") int year);
}
