CREATE TABLE filmster.movie_genre
(
    movie_id bigint NOT NULL,
    genre_id bigint NOT NULL,
    CONSTRAINT movie_genre_pk PRIMARY KEY (movie_id, genre_id),
    CONSTRAINT movie_genre_pk FOREIGN KEY (movie_id) REFERENCES filmster.movie (id)
);

#
# Hibernate: create table movie_actors (movie_id bigint not null, actor_id bigint not null) engine=InnoDB
#     Hibernate: create table movie_genre (movie_id bigint not null, genre_id bigint not null, primary key (movie_id, genre_id)) engine=InnoDB
#     Hibernate: alter table movie_actors add constraint FKcify69o6k32mj8hoya3skqghv foreign key (actor_id) references actor (id)
#     Hibernate: alter table movie_actors add constraint FKbsto8yef4btokhveihmkg8876 foreign key (movie_id) references movie (id)
#     Hibernate: alter table movie_genre add constraint FK86p3roa187k12avqfl28klp1q foreign key (genre_id) references genre (id)
#     Hibernate: alter table movie_genre add constraint FKp6vjabv2e2435at1hnuxg64yv foreign key (movie_id) references movie (id)