package com.puggysoft.controllers.users;

import com.puggysoft.services.users.ServiceTenantUserRoleDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTenantUserRoleDeleteById {

  @Autowired
  private ServiceTenantUserRoleDeleteById service;

  @DeleteMapping(path = "/api/v1/tenants-users-roles/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return service.deleteById(id);
  }
}
