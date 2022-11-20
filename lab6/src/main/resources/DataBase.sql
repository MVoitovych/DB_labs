CREATE DATABASE IF NOT EXISTS FireDepartment;
USE FireDepartment;
SET SQL_SAFE_UPDATES = 0;

DROP TABLE IF EXISTS `emergency_call`;
CREATE TABLE `emergency_call` (
    id int NOT NULL AUTO_INCREMENT,
    caller_id int,
    short_description varchar(40) NULL,
    departure_id int NOT NULL,
    CONSTRAINT call_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS departure_firecar;
CREATE TABLE departure_firecar (
    departure_id int NOT NULL,
    firecar_id int NOT NULL,
    CONSTRAINT departure_firecar_pk PRIMARY KEY (departure_id,firecar_id)
);

DROP TABLE IF EXISTS departure_fireman;
CREATE TABLE departure_fireman (
    departure_id int NOT NULL,
    fireman_id int NOT NULL,
    fireman_name varchar(25),
    fireman_surname varchar(25),
    CONSTRAINT departure_fireman_pk PRIMARY KEY (departure_id,fireman_id)
);

DROP TABLE IF EXISTS departure;
CREATE TABLE departure (
    id int NOT NULL AUTO_INCREMENT,
    short_description varchar(255) NULL,
    CONSTRAINT departure_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS firecar;
CREATE TABLE firecar (
    id int NOT NULL AUTO_INCREMENT,
    mark varchar(25) NULL,
    CONSTRAINT firecar_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS fireman;
CREATE TABLE fireman (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    surname varchar(25) NOT NULL,
    CONSTRAINT fireman_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS caller;
CREATE TABLE caller (
    id int PRIMARY KEY AUTO_INCREMENT,
    mobile_phone varchar(25) NOT NULL
);

DROP TABLE IF EXISTS caller_log;
CREATE TABLE caller_log (
    id int PRIMARY KEY AUTO_INCREMENT,
    log_type varchar(25) NULL,
    log_time datetime NULL
);

ALTER TABLE `emergency_call` ADD CONSTRAINT call_departure 
FOREIGN KEY call_departure (departure_id)
    REFERENCES departure (id);

ALTER TABLE departure_firecar ADD CONSTRAINT departure_firecar_departure 
FOREIGN KEY departure_firecar_departure (departure_id)
    REFERENCES departure (id);

ALTER TABLE departure_firecar ADD CONSTRAINT departure_firecar_firecar 
FOREIGN KEY departure_firecar_firecar (firecar_id)
    REFERENCES firecar (id);

ALTER TABLE departure_fireman ADD CONSTRAINT departure_fireman_departure 
FOREIGN KEY departure_fireman_departure (departure_id)
    REFERENCES departure (id);

ALTER TABLE departure_fireman ADD CONSTRAINT departure_fireman_fireman 
FOREIGN KEY departure_fireman_fireman (fireman_id)
    REFERENCES fireman (id);



