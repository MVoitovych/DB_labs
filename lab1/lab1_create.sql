-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-14 18:39:47.241

-- tables
-- Table: adress

CREATE DATABASE IF NOT EXISTS lab1;
USE lab1;

CREATE TABLE adress (
    id int NOT NULL AUTO_INCREMENT,
    city varchar(40) NULL,
    street varchar(255) NULL,
    adress varchar(25) NULL,
    CONSTRAINT adress_pk PRIMARY KEY (id)
);

-- Table: call
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
    CONSTRAINT departure_fireman_pk PRIMARY KEY (departure_id,fireman_id)
);

-- Table: fire_department
CREATE TABLE fire_department (
    id int NOT NULL AUTO_INCREMENT,
    adress_id int NOT NULL,
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
    departure_fireman_departure_id int NOT NULL,
    departure_fireman_fireman_id int NOT NULL,
    CONSTRAINT trauma_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: call_adress (table: call)
ALTER TABLE emergency_call ADD CONSTRAINT call_adress FOREIGN KEY call_adress (adress_id)
    REFERENCES adress (id);

-- Reference: call_caller (table: call)
ALTER TABLE emergency_call ADD CONSTRAINT call_caller FOREIGN KEY call_caller (caller_id)
    REFERENCES caller (id);

-- Reference: call_departure (table: call)
ALTER TABLE emergency_call ADD CONSTRAINT call_departure FOREIGN KEY call_departure (departure_id)
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

-- Reference: fire_department_adress (table: fire_department)
ALTER TABLE fire_department ADD CONSTRAINT fire_department_adress FOREIGN KEY fire_department_adress (adress_id)
    REFERENCES adress (id);

-- Reference: firecar_fire_department (table: firecar)
ALTER TABLE firecar ADD CONSTRAINT firecar_fire_department FOREIGN KEY firecar_fire_department (fire_department_id)
    REFERENCES fire_department (id);

-- Reference: fireman_fire_department (table: fireman)
ALTER TABLE fireman ADD CONSTRAINT fireman_fire_department FOREIGN KEY fireman_fire_department (fire_department_id)
    REFERENCES fire_department (id);

-- Reference: trauma_departure_fireman (table: trauma)
ALTER TABLE trauma ADD CONSTRAINT trauma_departure_fireman FOREIGN KEY trauma_departure_fireman (departure_fireman_departure_id,departure_fireman_fireman_id)
    REFERENCES departure_fireman (departure_id,fireman_id);

-- End of file.

