package com.puggysoft.controllers.users;

import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.services.users.ServiceUserGetFilterWithTenantSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerUserGetFilterWithTenantsSize {

  @Autowired
  private ServiceUserGetFilterWithTenantSize serviceUserGetFilterWithTenantSize;

  @PostMapping(path = "/api/v1/users/filter/with-tenants/size")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoUserFilter dtoUserFilter,
      @RequestParam Long pageSize,
      @RequestParam String tenant) {
    return serviceUserGetFilterWithTenantSize.getSize(dtoUserFilter, pageSize, tenant);
  }

}
