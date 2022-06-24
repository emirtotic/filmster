package com.filmster.service;

import com.filmster.dto.MovieDTO;
import com.filmster.entity.Movie;
import com.filmster.enums.Popularity;
import com.filmster.service.data.MovieData;

import java.util.List;

public interface MovieService {

    /**
     * Finding all movies from DB
     * @return List<MovieDTO>
     */
    List<MovieDTO> findAllMovies();

    /**
     * Creating new Movie
     * @param movieData
     * @return MovieDTO object
     */
    MovieDTO createMovie(MovieData movieData);

    /**
     * Find all movies by movieName
     * @param actorName
     * @return List<MovieDTO>
     */
    List<MovieDTO> findAllByName(String actorName);

    /**
     * Method for updating a movie
     * @param id
     * @param movieData
     * @return Updated MovieDTO object
     */
    MovieDTO updateMovie(Long id, MovieData movieData);

    /**
     * Finding movie by id
     * @param id
     * @return MovieDTO
     */
    MovieDTO findMovieById(Long id);

    /**
     *
     * @param id
     */
    void delete(Long id);

    /**
     * Find all movies from this year
     * @param year
     * @return List<MovieDTO> which are released in year from param
     */
    List<MovieDTO> findMoviesByYear(int year);

    /**
     * Find all movies before this year
     * @param year
     * @return List<MovieDTO> which are released before year from param
     */
    List<MovieDTO> findMoviesBeforeYear(int year);

    /**
     * Find all movies after this year
     * @param year
     * @return List<MovieDTO> which are released after the year from param
     */
    List<MovieDTO> findMoviesAfterYear(int year);

    /**
     * Find all movies by year and Genre
     * @param year
     * @return List<MovieDTO>
     */
    List<MovieDTO> findMoviesByYearAndGenre(int year, String genre);

    /**
     * Find movies by popularity status
     * @param popularity
     * @return List<MovieDTO> with desired popularity
     */
    List<MovieDTO> findAllMoviesByPopularity(Popularity popularity);
}
