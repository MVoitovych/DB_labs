-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-13 12:29:11.306

-- tables
-- Table: call

create database if not exists lab1;
use lab1;
CREATE TABLE `call` (
    id int NOT NULL AUTO_INCREMENT,
    caller_id int NOT NULL,
    adress varchar(255) NOT NULL,
    short_description varchar(400) NULL,
    full_description text NULL,
    call_time timestamp NULL,
    departure_id int NOT NULL,
    CONSTRAINT call_pk PRIMARY KEY (id)
);

-- Table: caller
CREATE TABLE caller (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NULL,
    surename varchar(25) NULL,
    phone_number varchar(11) NOT NULL,
    CONSTRAINT caller_pk PRIMARY KEY (id)
);

-- Table: departure
CREATE TABLE departure (
    id int NOT NULL AUTO_INCREMENT,
    short_description varchar(255) NULL,
    CONSTRAINT departure_pk PRIMARY KEY (id)
);

-- Table: departure_firecar
CREATE TABLE departure_firecar (
    departure_id int NOT NULL,
    firecar_id int NOT NULL,
    departure_time timestamp NULL,
    arrival_time timestamp NULL,
    CONSTRAINT departure_firecar_pk PRIMARY KEY (departure_id,firecar_id)
);

-- Table: departure_fireman
CREATE TABLE departure_fireman (
    departure_id int NOT NULL,
    fireman_id int NOT NULL,
    departure_time timestamp NULL,
    arrival_time timestamp NULL,
    trauma_id int NULL,
    CONSTRAINT departure_fireman_pk PRIMARY KEY (departure_id,fireman_id)
);

-- Table: fire_department
CREATE TABLE fire_department (
    id int NOT NULL AUTO_INCREMENT,
    city varchar(255) NOT NULL,
    adress varchar(255) NULL,
    CONSTRAINT id PRIMARY KEY (id)
);

-- Table: firecar
CREATE TABLE firecar (
    id int NOT NULL AUTO_INCREMENT,
    mark varchar(25) NULL,
    fire_department_id int NOT NULL,
    CONSTRAINT firecar_pk PRIMARY KEY (id)
);

-- Table: fireman
CREATE TABLE fireman (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    surename varchar(25) NOT NULL,
    fire_department_id int NOT NULL,
    CONSTRAINT fireman_pk PRIMARY KEY (id)
);

-- Table: trauma
CREATE TABLE trauma (
    id int NOT NULL AUTO_INCREMENT,
    hospital varchar(100) NULL,
    diagnosis varchar(255) NULL,
    injuries_description text NULL,
    CONSTRAINT trauma_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: call_caller (table: call)
ALTER TABLE `call` ADD CONSTRAINT call_caller FOREIGN KEY call_caller (caller_id)
    REFERENCES caller (id);

-- Reference: call_departure (table: call)
ALTER TABLE `call` ADD CONSTRAINT call_departure FOREIGN KEY call_departure (departure_id)
    REFERENCES departure (id);

-- Reference: departure_firecar_departure (table: departure_firecar)
ALTER TABLE departure_firecar ADD CONSTRAINT departure_firecar_departure FOREIGN KEY departure_firecar_departure (departure_id)
    REFERENCES departure (id);

-- Reference: departure_firecar_firecar (table: departure_firecar)
ALTER TABLE departure_firecar ADD CONSTRAINT departure_firecar_firecar FOREIGN KEY departure_firecar_firecar (firecar_id)
    REFERENCES firecar (id);

-- Reference: departure_fireman_departure (table: departure_fireman)
ALTER TABLE departure_fireman ADD CONSTRAINT departure_fireman_departure FOREIGN KEY departure_fireman_departure (departure_id)
    REFERENCES departure (id);

-- Reference: departure_fireman_fireman (table: departure_fireman)
ALTER TABLE departure_fireman ADD CONSTRAINT departure_fireman_fireman FOREIGN KEY departure_fireman_fireman (fireman_id)
    REFERENCES fireman (id);

-- Reference: departure_fireman_trauma (table: departure_fireman)
ALTER TABLE departure_fireman ADD CONSTRAINT departure_fireman_trauma FOREIGN KEY departure_fireman_trauma (trauma_id)
    REFERENCES trauma (id);

-- Reference: firecar_fire_department (table: firecar)
ALTER TABLE firecar ADD CONSTRAINT firecar_fire_department FOREIGN KEY firecar_fire_department (fire_department_id)
    REFERENCES fire_department (id);

-- Reference: fireman_fire_department (table: fireman)
ALTER TABLE fireman ADD CONSTRAINT fireman_fire_department FOREIGN KEY fireman_fire_department (fire_department_id)
    REFERENCES fire_department (id);

-- End of file.

