package com.filmster.mapper.decorator;

import com.filmster.entity.Genre;
import com.filmster.exception.GenreNotFound;
import com.filmster.mapper.GenreMapper;
import com.filmster.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.Set;

public abstract class GenreMapperDecorator implements GenreMapper {

    @Autowired
    @Qualifier("delegate")
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre mapGenre(Integer genre) {
        return genreRepository.findById(Long.valueOf(genre))
                .orElseThrow(() -> new GenreNotFound(Long.valueOf(genre)));
    }

    @Override
    public Set<Genre> mapGenres(Set<Integer> genres) {
        Set<Genre> gen = new HashSet<>();
        if (!genres.isEmpty()) {
            genres.forEach(genre -> gen.add(mapGenre(genre)));
        }
        return gen;
    }

}
