CREATE TABLE filmster.actor
(
    id            bigint NOT NULL AUTO_INCREMENT,
    first_name    varchar(50),
    last_name     varchar(50),
    age           int,
    date_of_birth date,
    gender        varchar(20),
    CONSTRAINT actor_pk PRIMARY KEY (id)
);