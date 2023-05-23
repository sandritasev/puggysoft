package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursosMaterias;
import com.puggysoft.entities.escuela.EntityEscuelaCursosMaterias;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaCursosMaterias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceEscuelaCursosMateriasCreate {

  @Autowired
  private IRepositoryEscuelaCursosMaterias repositoryEscuelaCursosMaterias;

  /** method for create. */
  public ResponseEntity<String> create(DtoEscuelaCursosMaterias dtoEscuelaCursosMaterias) {
    try {
      EntityEscuelaCursosMaterias entity = repositoryEscuelaCursosMaterias.save(dtoEscuelaCursosMaterias.dtoToEntity());
      DtoEscuelaCursosMaterias dto = DtoEscuelaCursosMaterias.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
