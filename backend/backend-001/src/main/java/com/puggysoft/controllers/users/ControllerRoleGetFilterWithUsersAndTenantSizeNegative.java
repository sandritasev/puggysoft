package com.puggysoft.controllers.users;

import com.puggysoft.dtos.users.DtoRoleFilter;
import com.puggysoft.services.users.ServiceRolesGetFilterWithUsersAndTenantSizeNegative;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerRoleGetFilterWithUsersAndTenantSizeNegative {

  @Autowired
  private ServiceRolesGetFilterWithUsersAndTenantSizeNegative service;

  @PostMapping(path = "/api/v1/roles/filter/without-users-and-tenants/size")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoRoleFilter dtoFilter,
      @RequestParam Long pageSize,
      @RequestParam Long idUser,
      @RequestParam String tenant) {
    return service.getSize(dtoFilter, pageSize, idUser, tenant);
  }

}
