package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursosEstudiantes;
import com.puggysoft.entities.escuela.EntityEscuelaCursosEstudiantes;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaCursosEstudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceEscuelaCursosEstudiantesCreate {

  @Autowired
  private IRepositoryEscuelaCursosEstudiantes repositoryEscuelaCursosEstudiantes;

  /** method for create. */
  public ResponseEntity<String> create(DtoEscuelaCursosEstudiantes dtoEscuelaCursosEstudiantes) {
    try {
      EntityEscuelaCursosEstudiantes entity = repositoryEscuelaCursosEstudiantes
          .save(dtoEscuelaCursosEstudiantes.dtoToEntity());
      DtoEscuelaCursosEstudiantes dto = DtoEscuelaCursosEstudiantes.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
