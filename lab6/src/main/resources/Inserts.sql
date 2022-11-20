USE FireDepartment;

INSERT INTO caller(mobile_phone) VALUES 
('0984874343'),
('0345675674'),
('0135467685'),
('0342234656'),
('0786756455'),
('0765879565'),
('0566786776'),
('0345766786'),
('0567474687'),
('0647868646');

INSERT INTO fireman(name, surname) VALUES
('name1', 'surename1'),
('name2', 'surename2'),
('name3', 'surename3'),
('name4', 'surename4'),
('name5', 'surename5'),
('name6', 'surename6'),
('name7', 'surename7'),
('name8', 'surename8'),
('name9', 'surename9'),
('name10', 'surename10');

INSERT INTO firecar(mark) VALUES 
('mark1'),
('mark2'),
('mark3'),
('mark4'),
('mark5'),
('mark6'),
('mark7'),
('mark8'),
('mark9'),
('mark10');

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

INSERT INTO departure_firecar(departure_id, firecar_id) VALUES 
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(3, 2),
(3, 5),
(4, 10);

INSERT INTO departure_fireman(departure_id, fireman_id) VALUES
(4, 10), 
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 10),
(3, 10),
(5, 9),
(6, 10),
(7, 10);

INSERT INTO `emergency_call` (short_description, caller_id, departure_id) VALUES
('description1', 1, 10),
('description2', 2, 9),
('description3', 3, 8),
('description4', 4, 7),
('description5', 5, 6),
('description6', 5, 5),
('description7', 6, 4),
('description8', 1, 3),
('description9', 2, 2),
('description10', 9 ,1);