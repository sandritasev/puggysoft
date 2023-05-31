package com.puggysoft.controllers.system;

import com.puggysoft.dtos.system.DtoTenant;
import com.puggysoft.services.system.ServiceTenantEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerTenantPut {

  @Autowired
  private ServiceTenantEditById serviceTenantEditById;

  @PutMapping(path = "/api/v1/tenants/{id}")
  public ResponseEntity<String> put(@PathVariable Long id, @RequestBody @Valid DtoTenant dtoTenant) {
    return serviceTenantEditById.editById(id, dtoTenant);
  }
}