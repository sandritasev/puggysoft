package com.puggysoft.services.system;

import com.puggysoft.repositories.system.IRepositoryTenantUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for delete a user-tenant by keys. */
@Service
public class ServiceTenantUserDeleteByKeys {

  @Autowired
  private IRepositoryTenantUser repositoryTenantUser;

  /** method for delete a user-tenant. */
  public ResponseEntity<String> deleteByKeys(String username, String tenant) {
    try {
      if (repositoryTenantUser.findByKeys(username, tenant).size() > 0) {
        repositoryTenantUser.deleteTenantUserByKeys(username, tenant);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}