package com.filmster.controller;

import com.filmster.dto.MovieDTO;
import com.filmster.enums.Popularity;
import com.filmster.service.MovieService;
import com.filmster.service.data.MovieData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/movie", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "01 Movie")
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "Find all Movies", description = "Finding all Movies from DB")
    @GetMapping()
    public ResponseEntity<List<MovieDTO>> findAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Operation(summary = "Create Movie", description = "Creating new Movie")
    @PostMapping("/new/create")
    public ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody MovieData movieData) {
        return new ResponseEntity<>(movieService.createMovie(movieData), HttpStatus.CREATED);
    }

    @Operation(summary = "Find Movies by Name", description = "Finding Movies from DB by Name")
    @GetMapping("/search/")
    public ResponseEntity<List<MovieDTO>> findAllMoviesByName(
            @RequestParam(defaultValue = StringUtils.EMPTY) String searchTerm) {
        return new ResponseEntity<>(movieService.findAllByName(searchTerm), HttpStatus.OK);
    }

    @Operation(summary = "Find Movie by ID", description = "Finding Movie from DB by ID")
    @GetMapping("/search/id/{movieId}")
    public ResponseEntity<MovieDTO> findMovieById(
            @PathVariable(name = "movieId") Long id) {
        return new ResponseEntity<>(movieService.findMovieById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update Movie", description = "Update Movie")
    @PutMapping("/update/{movieId}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable(name = "movieId") Long id,
                                                @Valid @RequestBody MovieData movieData) {
        return new ResponseEntity<>(movieService.updateMovie(id, movieData), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete Movie", description = "Delete Movie")
    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable(name = "movieId") Long id) {
        movieService.delete(id);
        return new ResponseEntity<>("Movie successfully deleted.", HttpStatus.OK);
    }

    @Operation(summary = "Find Movies from exact year", description = "Finding Movies by year")
    @GetMapping("/search/{year}")
    public ResponseEntity<List<MovieDTO>> findAllMoviesByYear(@RequestParam int year) {
        return new ResponseEntity<>(movieService.findMoviesByYear(year), HttpStatus.OK);
    }

    @Operation(summary = "Find Movies BEFORE year", description = "Finding Movies BEFORE year")
    @GetMapping("/search/before/{year}")
    public ResponseEntity<List<MovieDTO>> findAllMoviesBeforeYear(@RequestParam int year) {
        return new ResponseEntity<>(movieService.findMoviesBeforeYear(year), HttpStatus.OK);
    }

    @Operation(summary = "Find Movies AFTER year", description = "Finding Movies AFTER year")
    @GetMapping("/search/after/{year}")
    public ResponseEntity<List<MovieDTO>> findAllMoviesAfterYear(@RequestParam int year) {
        return new ResponseEntity<>(movieService.findMoviesAfterYear(year), HttpStatus.OK);
    }

    @Operation(summary = "Find By Year and Genre", description = "Finding Movies By Year and Genre")
    @GetMapping("/search/{year}{genre}")
    public ResponseEntity<List<MovieDTO>> findAllMoviesByYearAndGenre(@RequestParam int year,
                                                                 @RequestParam String genre) {
        return new ResponseEntity<>(movieService.findMoviesByYearAndGenre(year, genre), HttpStatus.OK);
    }

    @Operation(summary = "Find Movies by popularity", description = "Finding Movies by popularity")
    @GetMapping("/search/popularity/{popularity}")
    public ResponseEntity<List<MovieDTO>> findAllMoviesByPopularity(@RequestParam(name = "popularity") Popularity popularity) {
        return new ResponseEntity<>(movieService.findAllMoviesByPopularity(popularity), HttpStatus.OK);
    }
}
