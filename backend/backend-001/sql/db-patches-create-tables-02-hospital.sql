-- ------ HOSPITAL SYSTEM TABLES -------
-- Doctors
CREATE TABLE hospital_doctors_details(
   id BIGINT AUTO_INCREMENT,
   username VARCHAR(30) NOT NULL UNIQUE,
   specialization VARCHAR(60) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (username) REFERENCES users(username),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

-- Patients
CREATE TABLE hospital_patients_details(
   id BIGINT AUTO_INCREMENT,
   username VARCHAR(30) NOT NULL UNIQUE,
   sus_code VARCHAR(60) NOT NULL UNIQUE,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (username) REFERENCES users(username),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

-- Historial medico
CREATE TABLE hospital_patients_history_a(
   id BIGINT AUTO_INCREMENT,
   presion_arterial TEXT,
   frecuencia_cardiaca TEXT,
   saturacion_oxigeno TEXT, 
   altura TEXT,
   weight TEXT,
   temperatura TEXT,
   antecedentes TEXT,
   diagnostico TEXT,
   tratamiento TEXT,
   patient_username VARCHAR(30) NOT NULL,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username), -- doctor
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (patient_username) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
