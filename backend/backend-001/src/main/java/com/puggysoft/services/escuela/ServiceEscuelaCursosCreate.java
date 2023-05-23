package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursos;
import com.puggysoft.entities.escuela.EntityEscuelaCursos;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaCursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceEscuelaCursosCreate {

  @Autowired
  private IRepositoryEscuelaCursos repositoryEscuelaCursos;

  /** method for create. */
  public ResponseEntity<String> create(DtoEscuelaCursos dtoEscuelaCursos) {
    try {
      EntityEscuelaCursos entity = repositoryEscuelaCursos.save(dtoEscuelaCursos.dtoToEntity());
      DtoEscuelaCursos dto = DtoEscuelaCursos.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
