-- ------ RECURSOS SYSTEM TABLES -------
CREATE TABLE alcaldia_recursos_municipales(
   id BIGINT AUTO_INCREMENT,
   codigo VARCHAR(30) NOT NULL UNIQUE,
   name VARCHAR(120) NOT NULL,
   precio FLOAT(11,2) NOT NULL,
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

CREATE TABLE alcaldia_recursos_municipales_venta(
   id BIGINT AUTO_INCREMENT,
   cliente_nombre TEXT NOT NULL,
   cliente_ci_nit TEXT NOT NULL,
   direccion VARCHAR(120) NOT NULL,
   nota VARCHAR(120) NOT NULL,
   venta_status ENUM('ACTIVO', 'ANULADO') NOT NULL,
   venta_precio_total FLOAT(11,2),
   cliente_dinero FLOAT(11,2),
   cliente_cambio FLOAT(11,2),
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

CREATE TABLE alcaldia_recursos_municipales_venta_detalle(
   id BIGINT AUTO_INCREMENT,
   recurso_municipal_codigo VARCHAR(30) NOT NULL, 
   id_venta BIGINT,   
   precio_unidad FLOAT(11,2),
   cantidad INT,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   FOREIGN KEY (id_venta) REFERENCES alcaldia_recursos_municipales_venta(id),
   FOREIGN KEY (recurso_municipal_codigo) REFERENCES alcaldia_recursos_municipales(codigo),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
