CREATE TABLE filmster.movie_genre
(
    movie_id bigint NOT NULL,
    genre_id bigint NOT NULL,
    CONSTRAINT movie_genre_pk PRIMARY KEY (movie_id, genre_id),
    CONSTRAINT movie_genre_pk FOREIGN KEY (movie_id) REFERENCES filmster.movie (id)
);