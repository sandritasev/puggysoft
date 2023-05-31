package com.puggysoft.services.system;

import com.puggysoft.dtos.system.DtoTenant;
import com.puggysoft.repositories.system.IRepositoryTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit a tenant by id. */
@Service
public class ServiceTenantEditById {

  @Autowired
  private IRepositoryTenant repositoryTenant;

  /** method for edit a tenant. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoTenant dtoTenant) {
    if (repositoryTenant.existsById(id)) {
      try {
        dtoTenant.setId(id.longValue());
        repositoryTenant.save(dtoTenant.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}