package com.filmster.mapper.decorator;

import com.filmster.entity.Movie;
import com.filmster.mapper.ActorMapper;
import com.filmster.mapper.GenreMapper;
import com.filmster.mapper.MovieMapper;
import com.filmster.service.data.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class MovieDecoratorMapper implements MovieMapper {

    @Autowired
    @Qualifier("delegate")
    private MovieMapper movieMapper;

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private ActorMapper actorMapper;



    @Override
    public Movie mapDataToEntity(MovieData movieData) {

        Movie movie = movieMapper.mapDataToEntity(movieData);
        movie.setGenre(genreMapper.mapGenres(movieData.getGenre()));
        movie.setActors(actorMapper.mapActors(movieData.getActors()));
        return movie;
    }
}
