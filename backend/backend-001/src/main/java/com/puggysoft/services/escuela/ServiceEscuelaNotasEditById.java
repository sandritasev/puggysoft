package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotas;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaNotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceEscuelaNotasEditById {

  @Autowired
  private IRepositoryEscuelaNotas repositoryEscuelaNotas;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoEscuelaNotas dtoEscuelaNotas) {
    if (repositoryEscuelaNotas.existsById(id)) {
      try {
        dtoEscuelaNotas.setId(id.longValue());
        repositoryEscuelaNotas.save(dtoEscuelaNotas.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}