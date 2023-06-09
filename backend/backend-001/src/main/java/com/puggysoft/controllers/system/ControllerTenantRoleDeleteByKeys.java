package com.puggysoft.controllers.system;

import com.puggysoft.services.system.ServiceTenantRoleDeleteByKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTenantRoleDeleteByKeys {

  @Autowired
  private ServiceTenantRoleDeleteByKeys serviceTenantRoleDeleteByKeys;

  @DeleteMapping(path = "/api/v1/tenants-roles")
  public ResponseEntity<String> deleteByIds(
      @RequestParam String role,
      @RequestParam String tenant) {
    return serviceTenantRoleDeleteByKeys.deleteByKeys(role, tenant);
  }
}