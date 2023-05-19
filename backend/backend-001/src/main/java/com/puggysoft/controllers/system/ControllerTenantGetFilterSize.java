package com.puggysoft.controllers.system;

import com.puggysoft.dtos.system.DtoTenantFilter;
import com.puggysoft.services.system.ServiceTenantGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerTenantGetFilterSize {

  @Autowired
  private ServiceTenantGetFilterSize serviceTenantGetFilterSize;

  @PostMapping(path = "/api/v1/tenants/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoTenantFilter dtoTenantFilter, @PathVariable Long pageSize) {
    return serviceTenantGetFilterSize.getSize(dtoTenantFilter, pageSize);
  }

}
