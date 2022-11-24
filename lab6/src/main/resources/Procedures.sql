USE FireDepartment;

DROP PROCEDURE IF EXISTS CallerInsertProcedure;
DELIMITER //
CREATE
PROCEDURE CallerInsertProcedure(IN phone varchar(25))
 BEGIN
  DECLARE i int DEFAULT 0;
WHILE i < 10 DO
	INSERT INTO caller(mobile_phone)
	VALUES(CONCAT(phone, i));
    SET i = i + 1;
END WHILE;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS DepartureFiremanProcedure;
DELIMITER //
CREATE
	PROCEDURE DepartureFiremanProcedure(IN d_id int, IN f_id int)
BEGIN
UPDATE departure_fireman
	SET fireman_name = (SELECT name FROM fireman WHERE fireman.id = f_id),
	fireman_surname = (SELECT surname FROM fireman WHERE fireman.id = f_id)
	WHERE (departure_fireman.departure_id = d_id and departure_fireman.fireman_id = f_id);
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS FireCarProcedure;
DELIMITER //
CREATE
	PROCEDURE FireCarProcedure(IN in_mark varchar(25))
BEGIN
	DECLARE i int DEFAULT 1;
	WHILE i <= 10 DO
		INSERT INTO firecar(mark) values(CONCAT(in_mark, ' ' , i));
        SET i = i+1;
	END WHILE;
END//
DELIMITER ;


DROP FUNCTION IF EXISTS GetFireCarAvgID;
DELIMITER //
CREATE
	FUNCTION GetFireCarAvgID()
    RETURNS float
    DETERMINISTIC
BEGIN
DECLARE average float default 0;
SELECT AVG(id) INTO average FROM firecar;
RETURN average;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS GetAvgFireCarProcedure;
DELIMITER //
CREATE
	PROCEDURE GetAvgFireCarProcedure()
BEGIN
	UPDATE firecar SET mark = 'SOMETHING DO' WHERE id = FLOOR(GetFireCarAvgID());
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS CursorProcedure;
DELIMITER //
CREATE
	PROCEDURE CursorProcedure()
BEGIN
 DECLARE done int DEFAULT false;
 DECLARE markT varchar(25);
 DECLARE i int;
 DECLARE j int;
 DECLARE St_Cursor CURSOR
	FOR SELECT mark from firecar;
 DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
 OPEN St_Cursor;
 myLoop: LOOP
	FETCH St_Cursor INTO markT;
    IF done = true THEN LEAVE myLoop;
    END IF;
    SET @temp_table_query = CONCAT('CREATE TABLE `', markT, NOW(), '` (
    id int PRIMARY KEY AUTO_INCREMENT');
    SET j = CEIL(RAND() *10);
    SET i = 0;
    WHILE i < j DO
		SET @temp_table_query = CONCAT(@temp_table_query, ' , ', '`car', i, '` varchar(25) NULL');
        SET i = i + 1;
    END WHILE;
    SET @temp_table_query = CONCAT(@temp_table_query, ' );');
    PREPARE my_q FROM @temp_table_query;
    EXECUTE my_q;
    DEALLOCATE PREPARE my_q;
END LOOP;
CLOSE St_Cursor;
END//
DELIMITER ;


