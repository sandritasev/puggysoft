package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoHistorial;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoHistorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceUrbanismoHistorialEditById {

  @Autowired
  private IRepositoryUrbanismoHistorial repositoryUrbanismoHistorial;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoUrbanismoHistorial dtoUrbanismoHistorial) {
    if (repositoryUrbanismoHistorial.existsById(id)) {
      try {
        dtoUrbanismoHistorial.setId(id.longValue());
        repositoryUrbanismoHistorial.save(dtoUrbanismoHistorial.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}