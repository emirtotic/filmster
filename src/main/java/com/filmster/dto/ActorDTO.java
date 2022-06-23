package com.filmster.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.filmster.enums.Gender;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder  //TODO check these 2 annotations
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ActorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    //private List<MovieDTO> movies;
}
