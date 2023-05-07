package com.puggysoft.services.system;

import com.puggysoft.dtos.system.DtoTenant;
import com.puggysoft.repositories.system.IRepositoryTenant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/** Services for get. */
@Service
public class ServiceTenantByUser {

  @Autowired
  private IRepositoryTenant repository;

  /** method for retrive. */
  public ResponseEntity<List<DtoTenant>> getTenants(String username) {
    List<DtoTenant> listDtoTenants = repository.getTenantsByUsername(username)
            .stream()
            .map(DtoTenant::entityToDto)
            .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoTenants);
  }
}
