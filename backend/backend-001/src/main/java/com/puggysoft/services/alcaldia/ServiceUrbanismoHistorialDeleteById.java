package com.puggysoft.services.alcaldia;

import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoHistorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for delete by id. */
@Service
public class ServiceUrbanismoHistorialDeleteById {

  @Autowired
  private IRepositoryUrbanismoHistorial repositoryUrbanismoHistorial;

  /** method for delete. */
  public ResponseEntity<String> deleteById(Long id) {
    try {
      if (repositoryUrbanismoHistorial.existsById(id)) {
        repositoryUrbanismoHistorial.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
