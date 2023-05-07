-- ------ TICKETS SYSTEM TABLES -------
CREATE TABLE tickets_eventos(
   id BIGINT AUTO_INCREMENT,
   nombre VARCHAR(60) NOT NULL UNIQUE,
   short_name VARCHAR(30) NOT NULL UNIQUE,
   cantidad_tickets BIGINT NOT NULL,
   image LONGBLOB,
   fecha_fin DATE,
   fecha_inicio DATE,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE tickets(
   id BIGINT AUTO_INCREMENT,
   evento VARCHAR(30),
   uuid TEXT,
   cliente VARCHAR(30) NOT NULL,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (cliente) REFERENCES users(username),
   FOREIGN KEY (evento) REFERENCES tenants(short_name),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;