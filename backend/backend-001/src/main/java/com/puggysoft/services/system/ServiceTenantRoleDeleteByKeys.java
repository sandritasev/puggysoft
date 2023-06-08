package com.puggysoft.services.system;

import com.puggysoft.repositories.system.IRepositoryTenantRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for delete a role-tenant by keys. */
@Service
public class ServiceTenantRoleDeleteByKeys {

  @Autowired
  private IRepositoryTenantRole repositoryTenantRole;

  /** method for delete a role-tenant. */
  public ResponseEntity<String> deleteByKeys(String role, String tenant) {
    try {
      if (repositoryTenantRole.findByKeys(role, tenant).size() > 0) {
        repositoryTenantRole.deleteTenantRoleByKeys(role, tenant);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}