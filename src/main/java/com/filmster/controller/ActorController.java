package com.filmster.controller;

import com.filmster.dto.ActorDTO;
import com.filmster.service.ActorService;
import com.filmster.service.data.ActorData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
@RequestMapping(value = "/api/actor", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "02 Actor", description = "List of Actor API's")
public class ActorController {

    private final ActorService actorService;

    @Operation(summary = "Find all Actors", description = "Finding all Actors from DB")
    @GetMapping
    public ResponseEntity<List<ActorDTO>> findAllActors() {
        return new ResponseEntity<>(actorService.findAllActors(), HttpStatus.OK);
    }

    @Operation(summary = "Find Actor by ID", description = "Finding Actor by ID in DB")
    @GetMapping("/{actorId}")
    public ResponseEntity<ActorDTO> findById(@PathVariable(name = "actorId") Long id) {
        return new ResponseEntity<>(actorService.findActorById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Operation(summary = "Delete Actor by ID", description = "Deleting Actor by ID in DB")
    @DeleteMapping("/delete/{actorId}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "actorId") Long id) {
        actorService.deleteActorById(id);
        return new ResponseEntity<>("Actor successfully deleted.", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Operation(summary = "Create Actor", description = "Creating new Actor")
    @PostMapping("/create")
    public ResponseEntity<ActorDTO> createActor(@Valid @RequestBody ActorData actorData) {
        return new ResponseEntity<>(actorService.createActor(actorData), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Operation(summary = "Update Actor", description = "Updating an Actor")
    @PutMapping("/update/{actorId}")
    public ResponseEntity<ActorDTO> update(@PathVariable(name = "actorId") Long id, @Valid @RequestBody ActorData actorData) {
        return new ResponseEntity<>(actorService.updateActor(id, actorData), HttpStatus.OK);
    }

    @Operation(summary = "Find all Male Actors", description = "Retrieve all Male Actors from DB")
    @GetMapping("/male")
    public ResponseEntity<List<ActorDTO>> findAllMaleActors() {
        return new ResponseEntity<>(actorService.findAllMaleActors(), HttpStatus.OK);
    }

    @Operation(summary = "Find all Actresses", description = "Retrieve all Actresses from DB")
    @GetMapping("/female")
    public ResponseEntity<List<ActorDTO>> findAllActresses() {
        return new ResponseEntity<>(actorService.findAllActresses(), HttpStatus.OK);
    }

}
