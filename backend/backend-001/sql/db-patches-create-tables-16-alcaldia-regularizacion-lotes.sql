-- ------ ALCALDIA REGULARIZACION DE LOTES SYSTEM TABLES -------
CREATE TABLE alc_reg_lotes_extracto_bancario(
   id BIGINT AUTO_INCREMENT,
   fecha_extracto VARCHAR(10) NOT NULL,
   numero_envio TEXT,
   numero_comprobante VARCHAR(256) NOT NULL UNIQUE,
   cod_ope TEXT,
   glosa TEXT NOT NULL,
   numero_documento TEXT,
   dc TEXT NOT NULL,
   importe TEXT NOT NULL,
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

CREATE TABLE alc_reg_lotes(
   id BIGINT AUTO_INCREMENT,
   nombre_cliente VARCHAR(256) NOT NULL,
   ci_cliente VARCHAR(30) NOT NULL,
   numero_inmueble VARCHAR(120) UNIQUE,
   monto VARCHAR(120) NOT NULL,
   numero_comprobante VARCHAR(256) UNIQUE,
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   -- FOREIGN KEY (numero_comprobante) REFERENCES alc_reg_lotes_extracto_bancario(numero_comprobante),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
