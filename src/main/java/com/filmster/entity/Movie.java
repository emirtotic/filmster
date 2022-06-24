package com.filmster.entity;

import com.filmster.enums.Popularity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "movie", schema = "filmster")
public class Movie {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotBlank
    @Size(min = 10)
    @Column
    private String description;

    @Column
    private String director;

    @Positive
    @Min(1850)
    @Max(2023)
    @Column
    private Integer year;

    @ManyToMany(
            targetEntity=Actor.class,
            cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}
    )
    @JoinTable(
            joinColumns=@JoinColumn(name="movie_id"),
            inverseJoinColumns=@JoinColumn(name="actor_id")
    )
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH
            })
    @JoinTable(name = "movie_genre",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") })
    private Set<Genre> genre;

    @Enumerated(EnumType.STRING)
    @Column
    private Popularity popularity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getId(), movie.getId()) && Objects.equals(getName(), movie.getName()) &&
                Objects.equals(getDescription(), movie.getDescription()) && Objects.equals(getDirector(), movie.getDirector()) &&
                Objects.equals(getYear(), movie.getYear()) && Objects.equals(getActors(), movie.getActors()) &&
                Objects.equals(getGenre(), movie.getGenre()) && getPopularity() == movie.getPopularity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getDirector(), getYear(), getActors(), getGenre(), getPopularity());
    }
}
