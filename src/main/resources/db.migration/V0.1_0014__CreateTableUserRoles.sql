CREATE TABLE filmster.user_roles
(
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (user_id, role_id),
    CONSTRAINT user_role_fk FOREIGN KEY (user_id) REFERENCES filmster.users (id)
);