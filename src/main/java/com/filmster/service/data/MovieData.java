package com.filmster.service.data;

import com.filmster.entity.Actor;
import com.filmster.enums.Popularity;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MovieData {

    private Long id;
    private String name;
    private String description;
    private String director;
    private Integer year;
    private List<Integer> actors;
    private Set<Integer> genre = new HashSet<>();
    private Popularity popularity;
}
