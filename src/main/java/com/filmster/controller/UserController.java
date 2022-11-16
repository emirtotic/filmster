package com.filmster.controller;

import com.filmster.dto.ActorDTO;
import com.filmster.dto.UserDTO;
import com.filmster.service.ActorService;
import com.filmster.service.UserService;
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
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "06 Users", description = "List of User API's")
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Operation(summary = "Find all Users", description = "Finding all Users from DB")
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Operation(summary = "Find User by ID", description = "Finding User by ID in DB")
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findById(@PathVariable(name = "userId") Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }
}
