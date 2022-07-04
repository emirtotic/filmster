CREATE TABLE filmster.users
(
    id bigint NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    username varchar(255) NOT NULL,

    CONSTRAINT users_pk PRIMARY KEY (id)
);