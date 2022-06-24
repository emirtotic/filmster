package com.filmster.service.impl;

import com.filmster.dto.GenreDTO;
import com.filmster.entity.Genre;
import com.filmster.exception.GenreNotFound;
import com.filmster.mapper.GenreMapper;
import com.filmster.repository.GenreRepository;
import com.filmster.service.GenreService;
import com.filmster.service.data.GenreData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;


    /**
     * Finding all genres from DB
     * @return List<GenreDTO>
     */
    @Override
    public List<GenreDTO> findAllGenres() {
        return genreMapper.mapToDtoList(genreRepository.findAll());
    }

    /**
     * Finding genre by ID
     *
     * @param id
     * @return GenreDTO object
     */
    @Override
    public GenreDTO findById(Long id) {
        return genreMapper.mapToDto(genreRepository.findById(id).orElseThrow(() -> new GenreNotFound(id)));
    }

    /**
     * Creating new Genre
     * @param genreData - Genre object
     * @return GenreDTO object
     */
    @Override
    public GenreDTO createGenre(GenreData genreData) {
        Genre genre = genreMapper.mapDataToEntity(genreData);
        return genreMapper.mapToDto(genreRepository.save(genre));
    }

    /**
     * Delete Genre by ID
     * @param id Long
     */
    @Override
    public void deleteGenre(Long id) {
        genreRepository.findById(id).orElseThrow(() -> new GenreNotFound(id));
        genreRepository.deleteById(id);
    }

    /**
     * Updating the Genre object
     *
     * @param id    - Long
     * @param genreData - Genre object
     * @return GenreDTO object
     */
    @Override
    public GenreDTO updateGenre(Long id, GenreData genreData) {
        Genre genreFromDB = genreRepository.findById(id).orElseThrow(() -> new GenreNotFound(id));

        genreFromDB.setId(id);
        genreFromDB.setName(genreData.getName());

        return genreMapper.mapToDto(genreRepository.save(genreFromDB));
    }
}
