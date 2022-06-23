package com.filmster.mapper;

import com.filmster.dto.GenreDTO;
import com.filmster.dto.MovieDTO;
import com.filmster.entity.Genre;
import com.filmster.entity.Movie;
import com.filmster.mapper.decorator.GenreMapperDecorator;
import com.filmster.mapper.decorator.MovieDecoratorMapper;
import com.filmster.service.data.GenreData;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {MovieMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
@DecoratedWith(GenreMapperDecorator.class)
public interface GenreMapper {

    Genre mapToEntity(GenreDTO genreDTO);
    GenreDTO mapToDto(Genre genre);

    List<Genre> mapToEntityList(List<GenreDTO> genreDTOS);
    List<GenreDTO> mapToDtoList(List<Genre> genres);

    Set<Genre> mapGenres(Set<Integer> genres);
    Genre mapGenre(Integer genre);

    Genre mapDataToEntity(GenreData genreData);
}
