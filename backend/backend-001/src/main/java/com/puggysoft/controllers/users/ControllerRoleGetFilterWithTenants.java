package com.puggysoft.controllers.users;

import com.puggysoft.dtos.users.DtoRole;
import com.puggysoft.dtos.users.DtoRoleFilter;
import com.puggysoft.services.users.ServiceRoleGetFilterWithTenants;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRoleGetFilterWithTenants {

  @Autowired
  private ServiceRoleGetFilterWithTenants serviceRoleGetFilterWithTenants;

  @PostMapping(path = "/api/v1/roles/filter/with-tenants")
  public ResponseEntity<List<DtoRole>> getRoles(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoRoleFilter dtoRoleFilter,
      @RequestParam String tenant) {
    return serviceRoleGetFilterWithTenants.filter(dtoRoleFilter, page, size, tenant);
  }
}
