-- ------ PLANILLA SUELDOS SYSTEM TABLES -------
CREATE TABLE sueldos_detalle_contratacion(
   id BIGINT AUTO_INCREMENT,
   empleado VARCHAR(30) NOT NULL,
   fecha_ingreso DATE NOT NULL,
   cargo TEXT,
   haber_basico FLOAT(11,2) NOT NULL,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (empleado) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

-- sueldos_descuentos_ley
   -- afp, iva.
-- boleta de pago.