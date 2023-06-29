package com.puggysoft.controllers.users;

import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.services.users.ServiceUsersGetFilterWithRolesAndTenantSizeNegative;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerUserGetFilterWithRoleAndTenantSizeNegative {

  @Autowired
  private ServiceUsersGetFilterWithRolesAndTenantSizeNegative service;

  @PostMapping(path = "/api/v1/users/filter/without-roles-and-tenants/size")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoUserFilter dtoFilter,
      @RequestParam Long pageSize,
      @RequestParam Long idRol,
      @RequestParam String tenant) {
    return service.getSize(dtoFilter, pageSize, idRol, tenant);
  }

}
