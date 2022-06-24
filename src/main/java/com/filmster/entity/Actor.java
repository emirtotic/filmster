package com.filmster.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filmster.enums.Gender;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "actor", schema = "filmster")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column
    private int age;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

//    @ManyToMany(
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            mappedBy = "actors",
//            targetEntity = Movie.class
//    )
//    private List<Movie> movies;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getId(), actor.getId()) && getFirstName().equals(actor.getFirstName()) &&
                getLastName().equals(actor.getLastName()) && Objects.equals(getDateOfBirth(), actor.getDateOfBirth()) &&
                getGender() == actor.getGender();
    }
}
