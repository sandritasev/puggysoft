package com.puggysoft.controllers.system;

import com.puggysoft.dtos.system.DtoTenantFilter;
import com.puggysoft.services.system.ServiceTenantGetFilterWithoutRoleSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerTenantGetFilterWithouRoleSize {

  @Autowired
  private ServiceTenantGetFilterWithoutRoleSize serviceTenantGetFilterWithoutRoleSize;

  @PostMapping(path = "/api/v1/tenants/filter/without-roles/size")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoTenantFilter dtoTenantFilter,
      @RequestParam Long pageSize,
      @RequestParam String role) {
    return serviceTenantGetFilterWithoutRoleSize.getSize(dtoTenantFilter, pageSize, role);
  }

}
