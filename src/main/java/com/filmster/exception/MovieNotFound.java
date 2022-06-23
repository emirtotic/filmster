package com.filmster.exception;

public class MovieNotFound extends ApplicationException{

    public MovieNotFound(Long movieId) {
        super(String.format("Movie id=[%s] not found", movieId));
    }

    public MovieNotFound(String movieName) {
        super(String.format("Movie name=[%s] not found", movieName));
    }

}
