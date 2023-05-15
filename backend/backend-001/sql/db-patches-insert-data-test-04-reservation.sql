INSERT INTO res_resources (name, price_interval, image, description, created_by, tenant) VALUES
-- Canchas deportivas
("fronton 1 dia", "20", null, "dia", "adminreservation", "EMPRESA_1"),
("fronton 1 noche", "30", null, "noche", "adminreservation", "EMPRESA_1"),
("raquet 1 dia", "20", null, "dia", "adminreservation", "EMPRESA_1"),
("requet 1 noche", "30", null, "noche", "adminreservation", "EMPRESA_1"),
("wally 1", "30", null, "", "adminreservation", "EMPRESA_1"),
-- Hotel
("Habitacion simple 1", "100", null, "", "adminreservation", "EMPRESA_1"),
("Habitacion simple 2", "100", null, "", "adminreservation", "EMPRESA_1"),
("Habitacion simple 3", "100", null, "", "adminreservation", "EMPRESA_1"),
("Habitacion doble 1", "150", null, "", "adminreservation", "EMPRESA_1"),
("Habitacion doble 2", "150", null, "", "adminreservation", "EMPRESA_1"),
("Habitacion doble 3", "150", null, "", "adminreservation", "EMPRESA_1"),
("Habitacion triple 1", "300", null, "", "adminreservation", "EMPRESA_1"),
("Habitacion triple 2", "300", null, "", "adminreservation", "EMPRESA_1"),
("Habitacion triple 3", "300", null, "", "adminreservation", "EMPRESA_1"),
-- doctor
("recurso doctor", "120", null, "doctor", "adminreservation", "EMPRESA_1"),
("recurso mbros2", "120", null, "mbros2", "adminreservation", "EMPRESA_1");

-- schedule
INSERT INTO res_schedule (name, created_by, tenant) VALUES
-- canchas
("horario cancha dia", "adminreservation", "EMPRESA_1"),
("horario cancha noche", "adminreservation", "EMPRESA_1"),
("horario cancha", "adminreservation", "EMPRESA_1"),
-- hotel
("horario hotel", "adminreservation", "EMPRESA_1"),
-- doctor
("horario doctor", "adminreservation", "EMPRESA_1"),
("horario mbros2", "adminreservation", "EMPRESA_1");

INSERT INTO res_resources_schedule (id_schedule, id_resource, created_by, tenant) VALUES
-- canchas
(1000, 1000, "adminreservation", "EMPRESA_1"),
(1000, 1002, "adminreservation", "EMPRESA_1"),
(1001, 1001, "adminreservation", "EMPRESA_1"),
(1001, 1003, "adminreservation", "EMPRESA_1"),
(1002, 1004, "adminreservation", "EMPRESA_1"),
-- hotel
(1003, 1005, "adminreservation", "EMPRESA_1"),
(1003, 1006, "adminreservation", "EMPRESA_1"),
(1003, 1007, "adminreservation", "EMPRESA_1"),
(1003, 1008, "adminreservation", "EMPRESA_1"),
(1003, 1009, "adminreservation", "EMPRESA_1"),
(1003, 1010, "adminreservation", "EMPRESA_1"),
(1003, 1011, "adminreservation", "EMPRESA_1"),
(1003, 1012, "adminreservation", "EMPRESA_1"),
(1003, 1013, "adminreservation", "EMPRESA_1"),
-- doctor
(1004, 1014, "adminreservation", "EMPRESA_1"),
(1005, 1015, "adminreservation", "EMPRESA_1");

INSERT INTO res_interval_time (name, start_time, end_time, created_by, tenant) VALUES
-- canchas
("6:00 a 7:00", '06:00:00', '07:00:00', "adminreservation", "EMPRESA_1"),
("7:00 a 8:00", '07:00:00', '08:00:00', "adminreservation", "EMPRESA_1"),
("8:00 a 9:00", '08:00:00', '09:00:00', "adminreservation", "EMPRESA_1"),
("9:00 a 10:00", '09:00:00', '10:00:00', "adminreservation", "EMPRESA_1"),
("10:00 a 11:00", '10:00:00', '11:00:00', "adminreservation", "EMPRESA_1"),
("11:00 a 12:00", '11:00:00', '12:00:00', "adminreservation", "EMPRESA_1"),
("12:00 a 13:00", '12:00:00', '13:00:00', "adminreservation", "EMPRESA_1"),
("13:00 a 14:00", '13:00:00', '14:00:00', "adminreservation", "EMPRESA_1"),
("14:00 a 15:00", '14:00:00', '15:00:00', "adminreservation", "EMPRESA_1"),
("15:00 a 16:00", '15:00:00', '16:00:00', "adminreservation", "EMPRESA_1"),
("16:00 a 17:00", '16:00:00', '17:00:00', "adminreservation", "EMPRESA_1"),
("17:00 a 18:00", '17:00:00', '18:00:00', "adminreservation", "EMPRESA_1"),
("18:00 a 19:00", '18:00:00', '19:00:00', "adminreservation", "EMPRESA_1"),
("19:00 a 20:00", '19:00:00', '20:00:00', "adminreservation", "EMPRESA_1"),
("20:00 a 21:00", '20:00:00', '21:00:00', "adminreservation", "EMPRESA_1"),
("21:00 a 22:00", '21:00:00', '22:00:00', "adminreservation", "EMPRESA_1"),
("22:00 a 23:00", '22:00:00', '23:00:00', "adminreservation", "EMPRESA_1"),
("23:00 a 00:00", '23:00:00', '00:00:00', "adminreservation", "EMPRESA_1"),
-- hotel
("14:00 a 00:00", '14:00:00', '00:00:00', "adminreservation", "EMPRESA_1"),
("00:00 a 14:00", '00:00:00', '14:00:00', "adminreservation", "EMPRESA_1"),
-- doctor
("6:00 a 6:30", '06:00:00', '06:30:00', "adminreservation", "EMPRESA_1"),
("6:30 a 7:00", '06:30:00', '07:00:00', "adminreservation", "EMPRESA_1"),
("7:00 a 7:30", '07:00:00', '07:30:00', "adminreservation", "EMPRESA_1"),
("7:30 a 8:00", '07:30:00', '08:00:00', "adminreservation", "EMPRESA_1"),
("8:00 a 8:30", '08:00:00', '08:30:00', "adminreservation", "EMPRESA_1"),
("8:30 a 9:00", '08:30:00', '09:00:00', "adminreservation", "EMPRESA_1"),
("9:00 a 9:30", '09:00:00', '09:30:00', "adminreservation", "EMPRESA_1"),
("9:30 a 10:00", '09:30:00', '10:00:00', "adminreservation", "EMPRESA_1"),
("10:00 a 10:30", '10:00:00', '10:30:00', "adminreservation", "EMPRESA_1"),
("10:30 a 11:00", '10:30:00', '11:00:00', "adminreservation", "EMPRESA_1"),
("11:00 a 11:30", '11:00:00', '11:30:00', "adminreservation", "EMPRESA_1"),
("11:30 a 12:00", '11:30:00', '12:00:00', "adminreservation", "EMPRESA_1"),
("12:00 a 12:30", '12:00:00', '12:30:00', "adminreservation", "EMPRESA_1"),
("12:30 a 13:00", '12:30:00', '13:00:00', "adminreservation", "EMPRESA_1"),
("13:00 a 13:30", '13:00:00', '13:30:00', "adminreservation", "EMPRESA_1"),
("13:30 a 14:00", '13:30:00', '14:00:00', "adminreservation", "EMPRESA_1"),
("14:00 a 14:30", '14:00:00', '14:30:00', "adminreservation", "EMPRESA_1"),
("14:30 a 15:00", '14:30:00', '15:00:00', "adminreservation", "EMPRESA_1"),
("15:00 a 15:30", '15:00:00', '15:30:00', "adminreservation", "EMPRESA_1"),
("15:30 a 16:00", '15:30:00', '16:00:00', "adminreservation", "EMPRESA_1"),
("16:00 a 16:30", '16:00:00', '16:30:00', "adminreservation", "EMPRESA_1"),
("16:30 a 17:00", '16:30:00', '17:00:00', "adminreservation", "EMPRESA_1"),
("17:00 a 17:30", '17:00:00', '17:30:00', "adminreservation", "EMPRESA_1"),
("17:30 a 18:00", '17:30:00', '18:00:00', "adminreservation", "EMPRESA_1"),
("18:00 a 18:30", '18:00:00', '18:30:00', "adminreservation", "EMPRESA_1"),
("18:30 a 19:00", '18:30:00', '19:00:00', "adminreservation", "EMPRESA_1"),
("19:00 a 19:30", '19:00:00', '19:30:00', "adminreservation", "EMPRESA_1"),
("19:30 a 20:00", '19:30:00', '20:00:00', "adminreservation", "EMPRESA_1"),
("20:00 a 20:30", '20:00:00', '20:30:00', "adminreservation", "EMPRESA_1"),
("20:30 a 21:00", '20:30:00', '21:00:00', "adminreservation", "EMPRESA_1"),
("21:00 a 21:30", '21:00:00', '21:30:00', "adminreservation", "EMPRESA_1"),
("21:30 a 22:00", '21:30:00', '22:00:00', "adminreservation", "EMPRESA_1"),
("22:00 a 22:30", '22:00:00', '22:30:00', "adminreservation", "EMPRESA_1"),
("22:30 a 23:00", '22:30:00', '23:00:00', "adminreservation", "EMPRESA_1");

DROP PROCEDURE IF EXISTS assignIntervalTimeToSchedule;

DELIMITER $$
CREATE PROCEDURE assignIntervalTimeToSchedule()
  BEGIN
    DECLARE idIntervalTime INT DEFAULT 1000;
    WHILE idIntervalTime <= 1011 DO
      INSERT INTO res_schedule_interval_time (id_schedule, id_interval_time, created_by, tenant) values (1000, idIntervalTime, "adminreservation", "EMPRESA_1");
      INSERT INTO res_schedule_interval_time (id_schedule, id_interval_time, created_by, tenant) values (1002, idIntervalTime, "adminreservation", "EMPRESA_1");
      SET idIntervalTime = idIntervalTime+1;
    END WHILE;
    WHILE idIntervalTime <= 1017 DO
      INSERT INTO res_schedule_interval_time (id_schedule, id_interval_time, created_by, tenant) values (1001, idIntervalTime, "adminreservation", "EMPRESA_1");
      INSERT INTO res_schedule_interval_time (id_schedule, id_interval_time, created_by, tenant) values (1002, idIntervalTime, "adminreservation", "EMPRESA_1");
      SET idIntervalTime = idIntervalTime+1;
    END WHILE;
    WHILE idIntervalTime <= 1019 DO
      INSERT INTO res_schedule_interval_time (id_schedule, id_interval_time, created_by, tenant) values (1003, idIntervalTime, "adminreservation", "EMPRESA_1");
      SET idIntervalTime = idIntervalTime+1;
    END WHILE;
    WHILE idIntervalTime <= 1036 DO
      INSERT INTO res_schedule_interval_time (id_schedule, id_interval_time, created_by, tenant) values (1004, idIntervalTime, "adminreservation", "EMPRESA_1");
      SET idIntervalTime = idIntervalTime+1;
    END WHILE;
    WHILE idIntervalTime <= 1053 DO
      INSERT INTO res_schedule_interval_time (id_schedule, id_interval_time, created_by, tenant) values (1005, idIntervalTime, "adminreservation", "EMPRESA_1");
      SET idIntervalTime = idIntervalTime+1;
    END WHILE;
END; $$
DELIMITER ;

CALL assignIntervalTimeToSchedule();
DROP PROCEDURE assignIntervalTimeToSchedule;

INSERT INTO res_schedule_work_days (id_schedule, work_day, created_by, tenant) VALUES
-- cancha dia
(1000, 'MONDAY', "adminreservation", "EMPRESA_1"),
(1000, 'TUESDAY', "adminreservation", "EMPRESA_1"),
(1000, 'WEDNESDAY', "adminreservation", "EMPRESA_1"),
(1000, 'THURSDAY', "adminreservation", "EMPRESA_1"),
(1000, 'FRIDAY', "adminreservation", "EMPRESA_1"),
(1000, 'SATURDAY', "adminreservation", "EMPRESA_1"),
(1000, 'SUNDAY', "adminreservation", "EMPRESA_1"),
-- cancha noche
(1001, 'MONDAY', "adminreservation", "EMPRESA_1"),
(1001, 'TUESDAY', "adminreservation", "EMPRESA_1"),
(1001, 'WEDNESDAY', "adminreservation", "EMPRESA_1"),
(1001, 'THURSDAY', "adminreservation", "EMPRESA_1"),
(1001, 'FRIDAY', "adminreservation", "EMPRESA_1"),
(1001, 'SATURDAY', "adminreservation", "EMPRESA_1"),
(1001, 'SUNDAY', "adminreservation", "EMPRESA_1"),
-- cancha
(1002, 'MONDAY', "adminreservation", "EMPRESA_1"),
(1002, 'TUESDAY', "adminreservation", "EMPRESA_1"),
(1002, 'WEDNESDAY', "adminreservation", "EMPRESA_1"),
(1002, 'THURSDAY', "adminreservation", "EMPRESA_1"),
(1002, 'FRIDAY', "adminreservation", "EMPRESA_1"),
(1002, 'SATURDAY', "adminreservation", "EMPRESA_1"),
(1002, 'SUNDAY', "adminreservation", "EMPRESA_1"),
-- hotel
(1003, 'MONDAY', "adminreservation", "EMPRESA_1"),
(1003, 'TUESDAY', "adminreservation", "EMPRESA_1"),
(1003, 'WEDNESDAY', "adminreservation", "EMPRESA_1"),
(1003, 'THURSDAY', "adminreservation", "EMPRESA_1"),
(1003, 'FRIDAY', "adminreservation", "EMPRESA_1"),
(1003, 'SATURDAY', "adminreservation", "EMPRESA_1"),
(1003, 'SUNDAY', "adminreservation", "EMPRESA_1"),
-- doctor
(1004, 'MONDAY', "adminreservation", "EMPRESA_1"),
(1004, 'WEDNESDAY', "adminreservation", "EMPRESA_1"),
(1004, 'FRIDAY', "adminreservation", "EMPRESA_1"),
(1004, 'SATURDAY', "adminreservation", "EMPRESA_1"),
-- mbros2
(1005, 'THURSDAY', "adminreservation", "EMPRESA_1"),
(1005, 'FRIDAY', "adminreservation", "EMPRESA_1"),
(1005, 'TUESDAY', "adminreservation", "EMPRESA_1"),
(1005, 'SATURDAY', "adminreservation", "EMPRESA_1");


INSERT INTO res_bookings (id_resource, id_interval_time, booking_date, comments, voucher, status, created_by, tenant) VALUES
(1000, 1000, '2022-12-23', 'RESERVA DE PRUEBA', NULL, 'DONE', "adminreservation", "EMPRESA_1"),
(1000, 1000, '2022-12-24', 'RESERVA DE PRUEBA', NULL, 'DONE', "adminreservation", "EMPRESA_1"),
(1000, 1000, '2023-12-24', 'RESERVA DE PRUEBA', NULL, 'IN-PROGRESS', "adminreservation", "EMPRESA_1");
