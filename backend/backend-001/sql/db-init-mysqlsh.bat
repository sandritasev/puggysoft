@ECHO OFF
ECHO RESTARTING DATABASES PUGGYSOFT.
SET DB_HOST=192.168.0.100
SET DB_PORT=3306
SET DB_USER=root
SET DB_PASSWORD=secret123
SET DB_NAME=puggysoftdb
REM CREATE DB.
REM mysqlsh --sql --host=192.168.0.100 -port:3306 --user=root --password=secret123 < db-init.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% < db-patches-create-db.sql
REM CREATE TABLES.
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-01-users.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-02-hospital.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-03-sales.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-04-reservation.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-05-facturacion.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-06-projects.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-07-qa.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-08-pets.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-09-contabilidad.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-10-asistencia.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-11-planilla-sueldos.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-12-tickets.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-13-escuela-notas.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-14-alcaldia-recursos-municipales.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-15-alcaldia-urbanismo-tramite.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-create-tables-15-data-storage.sql

REM INSERT DATA.
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-01-users.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-02-hospital.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-03-sales.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-04-reservation.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-05-facturacion.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-06-projects.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-07-qa.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-08-pets.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-09-contabilidad.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-10-asistencia.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-11-planilla.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-12-tickets.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-13-escuela-notas.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-14-alcaldia-recursos-municipales.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-15-alcaldia-urbanismo-tramite.sql
mysqlsh --sql --host=%DB_HOST% -port:%DB_PORT% --user=%DB_USER% --password=%DB_PASSWORD% --database=%DB_NAME% < db-patches-insert-data-test-15-data-storage.sql
