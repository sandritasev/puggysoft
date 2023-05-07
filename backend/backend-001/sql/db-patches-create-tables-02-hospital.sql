-- ------ HOSPITAL SYSTEM TABLES -------
-- Doctors
CREATE TABLE hospital_doctors_details(
   id_user BIGINT NOT NULL UNIQUE,
   specialization VARCHAR(60) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (id_user) REFERENCES users(id),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username)
);

-- Patients:
CREATE TABLE hospital_patients_details(
   id_user BIGINT NOT NULL UNIQUE,
   sus_code VARCHAR(60) NOT NULL UNIQUE,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (id_user) REFERENCES users(id),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username)
);

-- Historial medico
CREATE TABLE hospital_patients_history(
   id BIGINT AUTO_INCREMENT,
   diagnostico TEXT,
   tratamiento TEXT,
   weight TEXT,
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
