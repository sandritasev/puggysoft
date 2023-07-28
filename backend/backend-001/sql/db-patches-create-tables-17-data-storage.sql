-- ------ ALMACENES SYSTEM TABLES -------
CREATE TABLE storage_schema(
   id BIGINT AUTO_INCREMENT,
   name VARCHAR(60) NOT NULL,
   short_name VARCHAR(30) NOT NULL,
   tenant VARCHAR(30) NOT NULL,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   UNIQUE (name, tenant),
   UNIQUE (short_name, tenant),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE storage_field(
   id BIGINT AUTO_INCREMENT,
   name VARCHAR(60) NOT NULL UNIQUE,
   short_name VARCHAR(30) NOT NULL UNIQUE,
   type ENUM('TEXTBOX', 'TEXTAREA','NUMBER', 'DATE', 'DROPDOWN') NOT NULL,
   textbox_option TEXT, -- [{ label: 'Bolivia', value: 'BO'}, { label: 'Argentina', value: 'ARG'}]
   tenant VARCHAR(30) NOT NULL,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE storage_schema_field(
   id BIGINT AUTO_INCREMENT,
   schema_ VARCHAR(30) NOT NULL,
   field VARCHAR(30) NOT NULL,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   tenant VARCHAR(30) NOT NULL,
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   FOREIGN KEY (schema_) REFERENCES storage_schema(short_name),
   FOREIGN KEY (field) REFERENCES storage_field(short_name),
   UNIQUE(schema_, field),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE storage_record(
   id BIGINT AUTO_INCREMENT,
   short_name VARCHAR(60) NOT NULL UNIQUE,
   schema_ VARCHAR(30) NOT NULL,
   aux TEXT,
   tenant VARCHAR(30) NOT NULL,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   FOREIGN KEY (schema_) REFERENCES storage_schema(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE storage_data(
   id BIGINT AUTO_INCREMENT,
   record VARCHAR(60) NOT NULL,
   field VARCHAR(60) NOT NULL,
   field_value TEXT NOT NULL,
   tenant VARCHAR(30) NOT NULL,
   created_by VARCHAR(30),
   updated_by VARCHAR(30),
   creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (created_by) REFERENCES users(username),
   FOREIGN KEY (updated_by) REFERENCES users(username),
   FOREIGN KEY (tenant) REFERENCES tenants(short_name),
   FOREIGN KEY (record) REFERENCES storage_record(short_name),
   FOREIGN KEY (field) REFERENCES storage_field(short_name),
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;
