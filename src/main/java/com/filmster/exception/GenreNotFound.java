package com.filmster.exception;

public class GenreNotFound extends ApplicationException{

    public GenreNotFound(Long genreId) {
        super(String.format("Genre id=[%s] not found", genreId));
    }

    public GenreNotFound(String genreName) {
        super(String.format("Genre name=[%s] not found", genreName));
    }

}
