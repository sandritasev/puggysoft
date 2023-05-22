package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaMaterias;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaMaterias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceEscuelaMateriasEditById {

  @Autowired
  private IRepositoryEscuelaMaterias repositoryEscuelaMaterias;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoEscuelaMaterias dtoEscuelaMaterias) {
    if (repositoryEscuelaMaterias.existsById(id)) {
      try {
        dtoEscuelaMaterias.setId(id.longValue());
        repositoryEscuelaMaterias.save(dtoEscuelaMaterias.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}