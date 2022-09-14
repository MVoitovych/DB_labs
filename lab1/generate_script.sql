USE lab1;

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
