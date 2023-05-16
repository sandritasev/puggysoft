package com.puggysoft.controllers.system;

import com.puggysoft.services.system.ServiceTenantUserDeleteByKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTenantUserDeleteByKeys {

  @Autowired
  private ServiceTenantUserDeleteByKeys serviceTenantUserDeleteByKeys;

  @DeleteMapping(path = "/api/v1/tenants-users")
  public ResponseEntity<String> deleteByIds(
      @RequestParam String username,
      @RequestParam String tenant) {
    return serviceTenantUserDeleteByKeys.deleteByKeys(username, tenant);
  }
}