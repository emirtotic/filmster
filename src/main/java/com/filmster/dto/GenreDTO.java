package com.filmster.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder  //TODO check these 2 annotations
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class GenreDTO {

    private Long id;
    private String name;
}
