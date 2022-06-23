package com.filmster.mapper;

import com.filmster.dto.MovieDTO;
import com.filmster.entity.Genre;
import com.filmster.entity.Movie;
import com.filmster.mapper.decorator.MovieDecoratorMapper;
import com.filmster.repository.GenreRepository;
import com.filmster.service.data.MovieData;
import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {GenreMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
@DecoratedWith(MovieDecoratorMapper.class)
public interface MovieMapper {

    Movie mapToEntity(MovieDTO movieDTO);
    MovieDTO mapToDto(Movie movie);
    List<Movie> mapToMoviesList(List<MovieDTO> movieDTOS);
    List<MovieDTO> mapToMoviesDtoList(List<Movie> movies);

    Movie mapDataToEntity(MovieData movieData);



}
