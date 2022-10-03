CREATE DATABASE IF NOT EXISTS lab3;
USE lab3;

DROP TABLE IF EXISTS emergency_call;
CREATE TABLE emergency_call (
    id int NOT NULL AUTO_INCREMENT,
    caller_id int NOT NULL,
    short_description varchar(400) NULL,
    full_description text NULL,
    call_time timestamp NULL,
    departure_id int NOT NULL,
    adress_id int NOT NULL,
    CONSTRAINT call_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS departure_firecar;
CREATE TABLE departure_firecar (
    departure_id int NOT NULL,
    firecar_id int NOT NULL,
    departure_time timestamp NULL,
    arrival_time timestamp NULL,
    CONSTRAINT departure_firecar_pk PRIMARY KEY (departure_id,firecar_id)
);

DROP TABLE IF EXISTS trauma;
CREATE TABLE trauma (
    id int NOT NULL AUTO_INCREMENT,
    hospital varchar(100) NULL,
    diagnosis varchar(255) NULL,
    injuries_description text NULL,
    departure_fireman_departure_id int NOT NULL,
    departure_fireman_fireman_id int NOT NULL,
    CONSTRAINT trauma_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS departure_fireman;
CREATE TABLE departure_fireman (
    departure_id int NOT NULL,
    fireman_id int NOT NULL,
    departure_time timestamp NULL,
    arrival_time timestamp NULL,
    CONSTRAINT departure_fireman_pk PRIMARY KEY (departure_id,fireman_id)
);

DROP TABLE IF EXISTS firecar;
CREATE TABLE firecar (
    id int NOT NULL AUTO_INCREMENT,
    mark varchar(25) NULL,
    fire_department_id int NOT NULL,
    CONSTRAINT firecar_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS fireman;
CREATE TABLE fireman (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    surename varchar(25) NOT NULL,
    fire_department_id int NOT NULL,
    CONSTRAINT fireman_pk PRIMARY KEY (id)
);
CREATE INDEX full_name_index ON fireman (surename, name) USING BTREE;

DROP TABLE IF EXISTS fire_department;
CREATE TABLE fire_department (
    id int NOT NULL AUTO_INCREMENT,
    adress_id int NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS adress;
CREATE TABLE adress (
    id int NOT NULL AUTO_INCREMENT,
    city varchar(40) NULL,
    street varchar(255) NULL,
    adress varchar(25) NULL,
    CONSTRAINT adress_pk PRIMARY KEY (id) 
);

DROP TABLE IF EXISTS departure;
CREATE TABLE departure (
    id int NOT NULL AUTO_INCREMENT,
    short_description varchar(255) NULL,
    CONSTRAINT departure_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS caller;
CREATE TABLE caller (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NULL,
    surename varchar(25) NULL,
    phone_number varchar(11) NOT NULL,
    CONSTRAINT caller_pk PRIMARY KEY (id)
);
CREATE INDEX full_name_index ON caller (surename, name) USING BTREE;

ALTER TABLE emergency_call ADD 
CONSTRAINT call_adress FOREIGN KEY call_adress (adress_id)
    REFERENCES adress (id);

ALTER TABLE emergency_call ADD 
CONSTRAINT call_caller FOREIGN KEY call_caller (caller_id)
    REFERENCES caller (id);
    
ALTER TABLE emergency_call ADD 
CONSTRAINT call_departure FOREIGN KEY call_departure (departure_id)
    REFERENCES departure (id);

ALTER TABLE departure_firecar ADD 
CONSTRAINT departure_firecar_departure FOREIGN KEY departure_firecar_departure (departure_id)
    REFERENCES departure (id);

ALTER TABLE departure_firecar ADD 
CONSTRAINT departure_firecar_firecar FOREIGN KEY departure_firecar_firecar (firecar_id)
    REFERENCES firecar (id);

ALTER TABLE departure_fireman ADD 
CONSTRAINT departure_fireman_departure FOREIGN KEY departure_fireman_departure (departure_id)
    REFERENCES departure (id);

ALTER TABLE departure_fireman ADD 
CONSTRAINT departure_fireman_fireman FOREIGN KEY departure_fireman_fireman (fireman_id)
    REFERENCES fireman (id);

ALTER TABLE fire_department ADD 
CONSTRAINT fire_department_adress FOREIGN KEY fire_department_adress (adress_id)
    REFERENCES adress (id);

ALTER TABLE firecar ADD 
CONSTRAINT firecar_fire_department FOREIGN KEY firecar_fire_department (fire_department_id)
    REFERENCES fire_department (id);

ALTER TABLE fireman ADD 
CONSTRAINT fireman_fire_department FOREIGN KEY fireman_fire_department (fire_department_id)
    REFERENCES fire_department (id);

ALTER TABLE trauma ADD 
CONSTRAINT trauma_departure_fireman FOREIGN KEY trauma_departure_fireman (departure_fireman_departure_id,departure_fireman_fireman_id)
    REFERENCES departure_fireman (departure_id,fireman_id);


INSERT INTO adress(city, street, adress) VALUES 
('city1', 'street1', '12'),
('city2', 'street2', '13'),
('city3', 'street3', '14'),
('city4', 'street4', '15'),
('city5', 'street5', '16'),
('city6', 'street6', '17'),
('city7', 'street7', '18'),
('city8', 'street8', '19'),
('city9', 'street9', '20'),
('city10', 'street10', '21') ;

INSERT INTO caller(name, surename, phone_number) VALUES 
('name1', 'surename1', '0987654321'),
('name2', 'surename2', '0987654321'),
('name3', 'surename3', '0987654321'),
('name4', 'surename4', '0987654321'),
('name5', 'surename5', '0987654321'),
('name6', 'surename6', '0987654321'),
('name7', 'surename7', '0987654321'),
('name8', 'surename8', '0987654321'),
('name9', 'surename9', '0987654321'),
('name10', 'surename10', '0987654321');

INSERT INTO fire_department(adress_id) VALUES 
(1),
(2),
(3),
(4),
(5),
(6),
(8),
(9),
(10);

INSERT INTO fireman(name, surename, fire_department_id) VALUES
('name1', 'surename1', 1),
('name2', 'surename2', 1),
('name3', 'surename3', 1),
('name4', 'surename4', 2),
('name5', 'surename5', 2),
('name6', 'surename6', 2),
('name7', 'surename7', 3),
('name8', 'surename8', 3),
('name9', 'surename9', 3),
('name10', 'surename10', 4);

INSERT INTO firecar(mark, fire_department_id) VALUES 
('mark1', 1),
('mark2', 2),
('mark3', 3),
('mark4', 4),
('mark5', 5),
('mark6', 6),
('mark7', 6),
('mark8', 1),
('mark9', 2),
('mark10', 4);

INSERT INTO departure (short_description) VALUES 
('description1'),
('description2'),
('description3'),
('description4'),
('description5'),
('description6'),
('description7'),
('description8'),
('description9'),
('description10');


INSERT INTO departure_firecar(departure_id, firecar_id, departure_time, arrival_time) VALUES 
(1, 1, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(1, 2, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(1, 3, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(2, 1, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(2, 2, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(2, 3, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(3, 1, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(3, 2, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(3, 5, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(4, 10, '2022-12-12 10:34:54', '2022-12-12 10:34:54');

INSERT INTO departure_fireman(departure_id, fireman_id, departure_time, arrival_time) VALUES
(4, 10, '2022-12-12 10:34:54', '2022-12-12 10:34:54'), 
(1, 1, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(1, 2, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(1, 3, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(2, 1, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(2, 10, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(3, 10, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
 (5, 9, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(6, 10, '2022-12-12 10:34:54', '2022-12-12 10:34:54'),
(7, 10, '2022-12-12 10:34:54', '2022-12-12 10:34:54');

INSERT INTO trauma(hospital, diagnosis, injuries_description, departure_fireman_departure_id, departure_fireman_fireman_id) VALUES
('hospital1', 'diagnosis1', 'description', 1, 1),
('hospital2', 'diagnosis2', 'description', 1, 2),
('hospital3', 'diagnosis3', 'description', 1, 3 );

INSERT INTO emergency_call (caller_id, short_description, full_description, call_time, departure_id, adress_id) VALUES
(1, 'description', 'full description', '2022-12-12 10:34:54', 10, 1 ),
(2, 'description', 'full description', '2022-12-12 10:34:54', 9, 2 ),
(3, 'description', 'full description', '2022-12-12 10:34:54', 8, 3 ),
(4, 'description', 'full description', '2022-12-12 10:34:54', 7, 4 ),
(5, 'description', 'full description', '2022-12-12 10:34:54', 6, 5 ),
(6, 'description', 'full description', '2022-12-12 10:34:54', 5, 6 ),
(7, 'description', 'full description', '2022-12-12 10:34:54', 4, 7 ),
(8, 'description', 'full description', '2022-12-12 10:34:54', 3, 8 ),
(9, 'description', 'full description', '2022-12-12 10:34:54', 2, 9 ),
(10, 'description', 'full description', '2022-12-12 10:34:54', 1, 10 );