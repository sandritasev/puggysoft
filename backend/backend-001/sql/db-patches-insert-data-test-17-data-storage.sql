-- ******* SCHEMAS *******
INSERT INTO storage_schema (name, short_name, created_by, tenant) VALUES ("Laptops", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema (name, short_name, created_by, tenant) VALUES ("Clientes", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");

-- ******* FIELDS *******
-- LAPTOP
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Marca", "MARCA", "text", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Modelo", "MODELO", "text", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Pulgadas", "PULGADAS", "number", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Memoria ram", "RAM", "number", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Fecha de compra", "FECHA_COMPRA", "date", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Detalles", "DETALLES", "textarea", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Procesador Version", "PRO_VERSION", "select", "[{\"key\": \"64bits\", \"label\": \"64bits\", \"value\": \"64\"}, {\"key\": \"32bits\", \"label\": \"32bits\", \"value\": \"32\"}]", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Precio de compra", "PRECIO_COMPRA", "number", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Precio de venta", "PRECIO_VENTA", "number", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Stock", "STOCK", "number", null, "SysStorageEncargado", "EMPRESA_1");
-- CLIENTE
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Nombres", "NOMBRES", "text", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("Apellidos", "APELLIDOS", "text", null, "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_field (name, short_name, type, textbox_option, created_by, tenant) VALUES ("NIT/CI", "NIT_CI", "text", null, "SysStorageEncargado", "EMPRESA_1");

-- ******* ATTRIBUTES BELONG TO SCHEMA *******
-- LAPTOP
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "MARCA", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "MODELO", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "PULGADAS", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "RAM", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "FECHA_COMPRA", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "PRO_VERSION", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "PRECIO_COMPRA", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "PRECIO_VENTA", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("LAPTOP", "STOCK", "SysStorageEncargado", "EMPRESA_1");
-- CLIENTE
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("CLIENTE", "NOMBRES", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("CLIENTE", "APELLIDOS", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_schema_field(schema_, field, created_by, tenant) VALUES ("CLIENTE", "NIT_CI", "SysStorageEncargado", "EMPRESA_1");


-- ******* RECORDS *******
-- PREFIX: {SCHEMA_NAME}_RECORD_{ID} OF THE RECORD. CREATE AND UPDATED IT.
-- LAPTOP
INSERT INTO storage_record(short_name, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_record(short_name, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_record(short_name, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
-- CLIENTE
INSERT INTO storage_record(short_name, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_1", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_record(short_name, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_2", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_record(short_name, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_3", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");


-- ******* DATA *******
-- LAPTOPS
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "MARCA", "Toshiba", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "MODELO", "Qosmio", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "PULGADAS", "17", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "RAM", "16", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "FECHA_COMPRA", "2023-05-26", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "PRO_VERSION", "64bits", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "PRECIO_COMPRA", "3000", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "PRECIO_VENTA", "7000", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_1", "STOCK", "50", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");

INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "MARCA", "HP", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "MODELO", "Omen", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "PULGADAS", "17", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "RAM", "32", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "FECHA_COMPRA", "2023-05-26", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "PRO_VERSION", "64bits", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "PRECIO_COMPRA", "3500", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "PRECIO_VENTA", "8000", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_2", "STOCK", "50", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");

INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "MARCA", "Apple", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "MODELO", "Macbook Pro", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "PULGADAS", "16", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "RAM", "16", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "FECHA_COMPRA", "2023-05-26", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "PRO_VERSION", "64bits", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "PRECIO_COMPRA", "8000", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "PRECIO_VENTA", "14000", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("LAPTOP_RECORD_3", "STOCK", "50", "LAPTOP", "SysStorageEncargado", "EMPRESA_1");
-- CLIENTES
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_1", "NOMBRES", "Juan Fernando", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_1", "APELLIDOS", "Perez del Corral", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_1", "NIT_CI", "44114477", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");

INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_2", "NOMBRES", "Sara Teresa", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_2", "APELLIDOS", "Sanchez del Pinar", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_2", "NIT_CI", "55447788", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");

INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_3", "NOMBRES", "Julieta", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_3", "APELLIDOS", "Ponce de Leon", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
INSERT INTO storage_data(record, field, field_value, schema_, created_by, tenant) VALUES ("CLIENTE_RECORD_3", "NIT_CI", "77551144", "CLIENTE", "SysStorageEncargado", "EMPRESA_1");
