package com.filmster.service;

import com.filmster.dto.GenreDTO;
import com.filmster.entity.Genre;
import com.filmster.service.data.GenreData;

import java.util.List;

public interface GenreService {

    /**
     * Finding all genres from DB
     * @return List<GenreDTO>
     */
    List<GenreDTO> findAllGenres();

    /**
     * Finding genre by ID
     * @return GenreDTO object
     */
    GenreDTO findById(Long id);

    /**
     * Creating new Genre
     * @param genreData - GenreData object
     * @return GenreDTO object
     */
    GenreDTO createGenre(GenreData genreData);

    /**
     * Delete Genre by ID
     * @param id Long
     */
    void deleteGenre(Long id);

    /**
     * Updating the Genre object
     * @param id - Long
     * @param genreData - Genre object
     * @return GenreDTO object
     */
    GenreDTO updateGenre(Long id, GenreData genreData);

}
