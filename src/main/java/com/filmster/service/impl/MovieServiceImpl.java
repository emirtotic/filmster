package com.filmster.service.impl;

import com.filmster.dto.MovieDTO;
import com.filmster.entity.Movie;
import com.filmster.exception.MovieNotFound;
import com.filmster.mapper.GenreMapper;
import com.filmster.mapper.MovieMapper;
import com.filmster.repository.MovieRepository;
import com.filmster.service.MovieService;
import com.filmster.service.data.MovieData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final GenreMapper genreMapper;


    /**
     * Finding all movies from DB
     *
     * @return List<MovieDTO>
     */
    @Override
    public List<MovieDTO> findAllMovies() {

        List<Movie> moviesFromDb = movieRepository.findAll();

        return movieMapper.mapToMoviesDtoList(moviesFromDb);
    }

    /**
     * Creating new Movie
     *
     * @param movieData
     * @return MovieDTO object
     */
    @Override
    @Transactional
    public MovieDTO createMovie(MovieData movieData) {
        Movie movie = movieMapper.mapDataToEntity(movieData);
        return movieMapper.mapToDto(movieRepository.save(movie));
    }

    /**
     * Find all movies by actor
     *
     * @param movieName
     * @return List<MovieDTO>
     */
    @Override
    public List<MovieDTO> findAllByName(String movieName) {
        return movieMapper.mapToMoviesDtoList(movieRepository.findByNameContainingIgnoreCase(movieName));
    }

    /**
     * Method for updating a movie
     *
     * @param id
     * @param movieData
     * @return Updated MovieDTO object
     */
    @Override
    public MovieDTO updateMovie(Long id, MovieData movieData) {

        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFound(id));

        movie.setId(id);
        movie.setName(movieData.getName());
        movie.setDescription(movieData.getDescription());
        movie.setDirector(movieData.getDirector());
        movie.setYear(movieData.getYear());
        movie.setGenre(genreMapper.mapGenres(movieData.getGenre()));
        movie.setPopularity(movieData.getPopularity());

        return movieMapper.mapToDto(movieRepository.save(movie));
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFound(id));
        movieRepository.deleteById(movie.getId());
    }

    /**
     * Find all movies from this year
     *
     * @param year
     * @return List<MovieDTO> which are released in year from param
     */
    @Override
    public List<MovieDTO> findMoviesByYear(int year) {
        return movieMapper.mapToMoviesDtoList(movieRepository.findAllMoviesByYear(year));
    }

    /**
     * Find all movies before this year
     *
     * @param year
     * @return List<MovieDTO> which are released before year from param
     */
    @Override
    public List<MovieDTO> findMoviesBeforeYear(int year) {
        return movieMapper.mapToMoviesDtoList(movieRepository.findAllMoviesBeforeYear(year));
    }

    /**
     * Find all movies after this year
     *
     * @param year
     * @return List<MovieDTO> which are released after the year from param
     */
    @Override
    public List<MovieDTO> findMoviesAfterYear(int year) {
        return movieMapper.mapToMoviesDtoList(movieRepository.findAllMoviesAfterYear(year));
    }

    /**
     * Find all movies by year and Genre
     *
     * @param year
     * @return List<MovieDTO>
     */
    @Override
    public List<MovieDTO> findMoviesByYearAndGenre(int year, String genre) {

        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> movieList = new ArrayList<>();

        allMovies.stream().forEach(movie -> {
            if (movie.getYear() == year) {
                movie.getGenre().forEach(gen -> {
                    if (gen.getName().equalsIgnoreCase(genre)) {
                        movieList.add(movie);
                    }
                });
            }
        });

        return movieMapper.mapToMoviesDtoList(movieList);
    }
}
