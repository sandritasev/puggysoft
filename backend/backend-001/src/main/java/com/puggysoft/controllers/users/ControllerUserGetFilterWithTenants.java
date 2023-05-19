package com.puggysoft.controllers.users;

import com.puggysoft.dtos.users.DtoUser;
import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.services.users.ServiceUserGetFilterWithTenants;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUserGetFilterWithTenants {

  @Autowired
  private ServiceUserGetFilterWithTenants serviceUserGetFilterWithTenants;

  @PostMapping(path = "/api/v1/users/filter/with-tenants")
  public ResponseEntity<List<DtoUser>> getUsers(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoUserFilter dtoUserFilter,
      @RequestParam String tenant) {
    return serviceUserGetFilterWithTenants.filter(dtoUserFilter, page, size, tenant);
  }
}
