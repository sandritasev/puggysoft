-- ------ CONTABILIDAD/ACCOUNTING SYSTEM TABLES -------
-- Cuentas
CREATE TABLE acc_cuentas(
   id BIGINT AUTO_INCREMENT,
   codigo VARCHAR(120) UNIQUE,
   name TEXT NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   folio TEXT,
   aux TEXT,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

-- Codigo de comercio dice que conservar 5 años.
-- Ley 2492 dice que debemos convervar 8 años.
-- CDI Comprobante de Diario Ingreso.
-- CDE Comprobante de Diario Egreso.
-- CDT Comprobante de Diario Transaccion.
-- Firma Auxiliar contable.
-- Firma Revisado por contador jefe.
-- Firma Aprobado por gerente general.
-- De aca se saca el libro diario.
-- comprobante diario, tambien se le llama asiento diario en libro diario.
CREATE TABLE acc_comprobante_diario(
   id BIGINT AUTO_INCREMENT, -- Numero de asiento
   razon_social TEXT NOT NULL,
   tipo ENUM('CDI', 'CDE', 'CDT') NOT NULL,
   moneda TEXT NOT NULL,
   recibimos_de TEXT NOT NULL,
   por_concepto_de TEXT NOT NULL,
   numero_cheque TEXT,
   nombre_banco TEXT,
   tipo_cambio_tc TEXT,
   monto_total FLOAT(11,2),
   comprobante LONGBLOB,
   revisado_por VARCHAR(30) NOT NULL,
   aprobado_por VARCHAR(30) NOT NULL,
   locacion TEXT,
   fecha_transaccion DATE,
   aux TEXT,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username), -- preparado por
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (revisado_por) REFERENCES users(username),
   FOREIGN KEY (aprobado_por) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE acc_comprobante_diario_detalle(
   id BIGINT AUTO_INCREMENT,
   codigo_cuenta VARCHAR(120) NOT NULL,
   comprobante_diario BIGINT NOT NULL,
   debe_haber ENUM('DEBE', 'HABER') NOT NULL,
   valor_debe_haber FLOAT(11,2) NOT NULL,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   FOREIGN KEY (codigo_cuenta) REFERENCES acc_cuentas(codigo),
   FOREIGN KEY (comprobante_diario) REFERENCES acc_comprobante_diario(id),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
