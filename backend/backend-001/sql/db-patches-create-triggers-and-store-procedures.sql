DROP PROCEDURE IF EXISTS createSystemPropertiesForNewTenant;

DELIMITER $$
CREATE PROCEDURE createSystemPropertiesForNewTenant(IN tenantName VARCHAR(30))
  BEGIN
    INSERT INTO system_properties (name,value,tenant,created_by) values ('SYS_AUTO_USER_REG','FALSE',tenantName, 'admin');
    INSERT INTO system_properties (name,value,tenant,created_by) values ('SYS_SALE_BILLING','FALSE',tenantName, 'admin');
END; $$
DELIMITER ;


DROP TRIGGER IF EXISTS triggerCreateSystemPropertiesForNewTenant;
DELIMITER $$
CREATE TRIGGER triggerCreateSystemPropertiesForNewTenant
    AFTER INSERT ON tenants FOR EACH ROW
    CALL createSystemPropertiesForNewTenant(NEW.short_name) $$
END;

DELIMITER ;