package com.filmster.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.filmster.enums.Popularity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder  //TODO check these 2 annotations
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class MovieDTO {

    private Long id;
    private String name;
    private String description;
    private String director;
    private Integer year;
    private Set<GenreDTO> genre;
    private List<ActorDTO> actors;
    private Popularity popularity;
}
