INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(1, 0, '1943-08-17', 'Robert', 'MALE', 'De Niro');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(2, 0, '1962-07-03', 'Tom', 'MALE', 'Cruise');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(3, 0, '1959-12-31', 'Val', 'MALE', 'Kilmer');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(4, 0, '1957-07-09', 'Kelly', 'FEMALE', 'McGillis');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(5, 0, '1940-04-25', 'Al', 'MALE', 'Pacino');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(6, 0, '1943-02-09', 'Joe', 'MALE', 'Pesci');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(7, 0, '1937-08-08', 'Dustin', 'MALE', 'Hoffman');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(8, 0, '1937-04-22', 'Jack', 'MALE', 'Nicholson');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(9, 0, '1930-05-31', 'Clint', 'MALE', 'Wastwood');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(10, 0, '1974-11-11', 'Leonardo', 'MALE', 'DiCaprio');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(11, 0, '1967-06-20', 'Nicole', 'FEMALE', 'Kidman');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(12, 0, '1982-11-12', 'Anne', 'FEMALE', 'Hathaway');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(13, 0, '1966-08-14', 'Halle', 'FEMALE', 'Berry');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(14, 0, '1967-10-28', 'Julia', 'FEMALE', 'Roberts');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(15, 0, '1962-11-19', 'Jodie', 'FEMALE', 'Foster');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(16, 0, '1937-12-31', 'Anthony', 'MALE', 'Hopkins');

INSERT INTO filmster.actor(id, age, date_of_birth, first_name, gender, last_name)
VALUES(17, 0, '1963-12-18', 'Brad', 'MALE', 'Pitt');

update filmster.actor
set age = (SELECT EXTRACT(YEAR FROM CURRENT_DATE)) - (SELECT EXTRACT(YEAR FROM date_of_birth));