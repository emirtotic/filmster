package com.filmster.service.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.filmster.enums.Gender;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ActorData {

    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
}
