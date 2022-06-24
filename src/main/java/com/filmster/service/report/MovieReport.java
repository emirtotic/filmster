package com.filmster.service.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieReport {

    private String movieName;
    private String description;
    private String director;
    private int year;
    private String popularity;
    private List<String> genre;
    private List<String> actors;

}
