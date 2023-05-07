package com.puggysoft.controllers.system;

import com.puggysoft.dtos.system.DtoTenant;
import com.puggysoft.services.system.ServiceTenantByUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTenantByUser {

  @Autowired
  private ServiceTenantByUser service;

  @GetMapping(path = "/api/v1/tenants-by-user")
  public ResponseEntity<List<DtoTenant>> get(
      @RequestParam String username
  ) {
    return service.getTenants(username);
  }
}
