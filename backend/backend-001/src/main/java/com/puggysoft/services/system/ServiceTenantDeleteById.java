package com.puggysoft.services.system;

import com.puggysoft.repositories.system.IRepositoryTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for delete a tenant by id. */
@Service
public class ServiceTenantDeleteById {

  @Autowired
  private IRepositoryTenant repositoryTenant;

  /** method for delete a tenant. */
  public ResponseEntity<String> deleteById(Long id) {
    try {
      if (repositoryTenant.existsById(id)) {
        repositoryTenant.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}