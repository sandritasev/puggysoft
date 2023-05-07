-- ------ PETS SYSTEM TABLES -------
-- Pets
CREATE TABLE pets_pets(
   id BIGINT AUTO_INCREMENT,
   name TEXT NOT NULL,
   birth_date DATE NOT NULL,
   sex VARCHAR(10) NOT NULL,
   especie TEXT NOT NULL,
   raza TEXT NOT NULL,
   color TEXT NOT NULL,
   dueno VARCHAR(30) NOT NULL,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (dueno) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE pets_historial(
   id BIGINT AUTO_INCREMENT,
   diagnostico TEXT NOT NULL,
   tratamiento TEXT NOT NULL,
   weight TEXT NOT NULL,
   pet_id BIGINT,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   FOREIGN KEY (pet_id) REFERENCES pets_pets(id),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
