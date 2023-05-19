package com.puggysoft.controllers.system;

import com.puggysoft.dtos.system.DtoTenantFilter;
import com.puggysoft.services.system.ServiceTenantGetFilterWithUserSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerTenantGetFilterWithUserSize {

  @Autowired
  private ServiceTenantGetFilterWithUserSize serviceTenantGetFilterWithUserSize;

  @PostMapping(path = "/api/v1/tenants/filter/with-users/size")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoTenantFilter dtoTenantFilter,
      @RequestParam Long pageSize,
      @RequestParam String username) {
    return serviceTenantGetFilterWithUserSize.getSize(dtoTenantFilter, pageSize, username);
  }

}
