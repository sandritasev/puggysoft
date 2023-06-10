package com.puggysoft.controllers.system;

import com.puggysoft.dtos.system.DtoTenantRole;
import com.puggysoft.services.system.ServiceTenantRoleCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTenantRolePost {

  @Autowired
  private ServiceTenantRoleCreate serviceTenantRoleCreate;

  @PostMapping(path = "/api/v1/tenants-roles")
  public ResponseEntity<String> post(@RequestBody @Valid DtoTenantRole dtoTenantRole) {
    return serviceTenantRoleCreate.create(dtoTenantRole);
  }
}
