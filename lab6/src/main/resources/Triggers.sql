USE FireDepartment;
Delimiter //
CREATE TRIGGER BeforeInsertCall
BEFORE INSERT 
ON emergency_call FOR EACH ROW
BEGIN
IF new.caller_id NOT IN (SELECT id FROM caller WHERE id = new.caller_id) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'no caller with this id';
END IF;
END//
Delimiter ;

Delimiter //
CREATE TRIGGER BeforeDeleteCaller
BEFORE DELETE 
ON caller FOR EACH ROW
BEGIN
IF old.id IN (SELECT caller_id FROM emergency_call WHERE caller_id = old.id) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'you cant delete this caller';
END IF;
END//
Delimiter ;

Delimiter //
CREATE TRIGGER AfterDeleteCallerLogger
AFTER DELETE 
ON caller FOR EACH ROW
BEGIN
INSERT INTO caller_log(log_type, log_time) values (CONCAT(USER(), ' DELETE'), NOW());
END//
Delimiter ;

Delimiter //
CREATE TRIGGER AfterInsertCallerLogger
AFTER INSERT 
ON caller FOR EACH ROW
BEGIN
INSERT INTO caller_log(log_type, log_time) values (CONCAT(USER(), ' INSERT'), NOW());
END//
Delimiter ;

Delimiter //
CREATE TRIGGER CheckCallerNumber
BEFORE INSERT
ON caller FOR EACH ROW
BEGIN
IF (new.mobile_phone NOT RLIKE '^[0]') THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'incorrect number format';
END IF;
END//
Delimiter ;




