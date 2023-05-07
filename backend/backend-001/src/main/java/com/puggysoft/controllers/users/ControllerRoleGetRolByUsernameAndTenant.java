package com.puggysoft.controllers.users;

import com.puggysoft.dtos.users.DtoRole;
import com.puggysoft.services.users.ServiceRoleGetByUsernameAndTenant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRoleGetRolByUsernameAndTenant {

  @Autowired
  private ServiceRoleGetByUsernameAndTenant service;

  @GetMapping(path = "/api/v1/roles/username-and-tenant")
  public ResponseEntity<List<DtoRole>> getByUsernameAndTenant(
      @RequestParam String username,
      @RequestParam String tenant
  ) {
    return service.getByUsernameAndTenant(username, tenant);
  }

}