package com.filmster.mapper.decorator;

import com.filmster.entity.Genre;
import com.filmster.entity.Movie;
import com.filmster.exception.GenreNotFound;
import com.filmster.mapper.GenreMapper;
import com.filmster.mapper.MovieMapper;
import com.filmster.repository.GenreRepository;
import com.filmster.service.data.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.Set;

public abstract class MovieDecoratorMapper implements MovieMapper {

    @Autowired
    @Qualifier("delegate")
    private MovieMapper movieMapper;

    @Autowired
    private GenreMapper genreMapper;


    @Override
    public Movie mapDataToEntity(MovieData movieData) {
        Movie movie = movieMapper.mapDataToEntity(movieData);
        movie.setGenre(genreMapper.mapGenres(movieData.getGenre()));
        return movie;
    }
}
