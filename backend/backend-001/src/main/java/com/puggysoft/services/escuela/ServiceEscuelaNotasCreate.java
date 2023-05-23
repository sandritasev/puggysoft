package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotas;
import com.puggysoft.entities.escuela.EntityEscuelaNotas;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaNotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceEscuelaNotasCreate {

  @Autowired
  private IRepositoryEscuelaNotas repositoryEscuelaNotas;

  /** method for create. */
  public ResponseEntity<String> create(DtoEscuelaNotas dtoEscuelaNotas) {
    try {
      EntityEscuelaNotas entity = repositoryEscuelaNotas.save(dtoEscuelaNotas.dtoToEntity());
      DtoEscuelaNotas dto = DtoEscuelaNotas.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
