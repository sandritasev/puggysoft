package com.puggysoft.controllers.users;

import com.puggysoft.dtos.users.DtoUser;
import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.services.users.ServiceUsersGetFilterWithRolesAndTenantNegative;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUserGetFilterWithRoleAndTenantNegative {

  @Autowired
  private ServiceUsersGetFilterWithRolesAndTenantNegative service;

  @PostMapping(path = "/api/v1/users/filter/without-roles-and-tenants")
  public ResponseEntity<List<DtoUser>> getUsers(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoUserFilter dtoFilter,
      @RequestParam Long idRol,
      @RequestParam String tenant) {
    return service.filter(dtoFilter, page, size, idRol, tenant);
  }
}
