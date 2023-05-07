package com.puggysoft.services.users;

import com.puggysoft.dtos.users.DtoRole;
import com.puggysoft.repositories.users.IRepositoryRole;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/** Services for get all. */
@Service
public class ServiceRoleGetByUsernameAndTenant {

  @Autowired
  private IRepositoryRole repositoryRole;

  /** method for retrive. */
  public ResponseEntity<List<DtoRole>> getByUsernameAndTenant(String username, String tenant) {
    List<DtoRole> listDtoRole = repositoryRole.findRolesByUsernameAndTenant(username, tenant)
            .stream()
            .map(DtoRole::entityToDto)
            .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoRole);
  }
}
