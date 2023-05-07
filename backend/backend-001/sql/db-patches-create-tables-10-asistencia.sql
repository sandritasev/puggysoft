-- ------ CONTROL DE ASISTENCIA SYSTEM TABLES -------
CREATE TABLE asistencia_control(
   id BIGINT AUTO_INCREMENT,
   persona VARCHAR(30) NOT NULL,
   detalle TEXT, -- ASISTENCIA, RETRASO, PERMISO, FALTA.
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (persona) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
