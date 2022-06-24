CREATE TABLE filmster.movie_actors
(
    movie_id bigint NOT NULL,
    actor_id bigint NOT NULL,
    CONSTRAINT movie_actors_pk PRIMARY KEY (movie_id, actor_id),
    CONSTRAINT movie_actors_pk FOREIGN KEY (movie_id) REFERENCES filmster.movie (id)
);