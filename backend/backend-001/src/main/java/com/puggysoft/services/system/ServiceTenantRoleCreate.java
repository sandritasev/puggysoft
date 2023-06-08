package com.puggysoft.services.system;

import com.puggysoft.dtos.system.DtoTenantRole;
import com.puggysoft.entities.system.EntityTenantRole;
import com.puggysoft.repositories.system.IRepositoryTenantRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceTenantRoleCreate {

  @Autowired
  private IRepositoryTenantRole repositoryTenantRole;

  /** method for create. */
  public ResponseEntity<String> create(DtoTenantRole dtoTenantRole) {
    try {
      EntityTenantRole entity = repositoryTenantRole.save(dtoTenantRole.dtoToEntity());
      DtoTenantRole dto = DtoTenantRole.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}