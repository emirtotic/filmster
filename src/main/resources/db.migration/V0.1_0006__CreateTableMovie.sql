CREATE TABLE filmster.movie
(
    id          bigint       NOT NULL AUTO_INCREMENT,
    description varchar(255),
    director    varchar(255),
    name        varchar(255) NOT NULL,
    popularity  varchar(255),
    year        integer,
    CONSTRAINT genre_pk PRIMARY KEY (id)
);