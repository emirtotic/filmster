package com.filmster.controller;

import com.filmster.dto.GenreDTO;
import com.filmster.entity.Genre;
import com.filmster.service.GenreService;
import com.filmster.service.data.GenreData;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genre")
@Validated
@Api(value = "List of Genre API interfaces", tags = "03 Genre")
public class GenreController {

    private final GenreService genreService;

    @Operation(summary = "Find all Genres", description = "Finding all Genres from DB")
    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> findAllGenres() {
        return new ResponseEntity<>(genreService.findAllGenres(), HttpStatus.OK);
    }

    @Operation(summary = "Find By ID", description = "Finding Genre by ID")
    @GetMapping("/{genreId}")
    public ResponseEntity<GenreDTO> findGenreById(@PathVariable(name = "genreId") Long id) {
        return new ResponseEntity<>(genreService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete By ID", description = "Delete Genre by ID")
    @DeleteMapping("/delete/{genreId}")
    public ResponseEntity<String> deleteGenre(@PathVariable(name = "genreId") Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>("Genre successfully deleted.", HttpStatus.OK);
    }

    @Operation(summary = "Create Genre", description = "Creating new Genre")
    @PostMapping("/create")
    public ResponseEntity<GenreDTO> createGenre(@Valid @RequestBody GenreData genreData) {
        return new ResponseEntity<>(genreService.createGenre(genreData), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Genre", description = "Update Genre")
    @PutMapping("/update/{genreId}")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable(name = "genreId") Long id, @Valid @RequestBody GenreData genreData) {
        return new ResponseEntity<>(genreService.updateGenre(id, genreData), HttpStatus.OK);
    }
}
