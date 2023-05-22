package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotasMaterias;
import com.puggysoft.entities.escuela.EntityEscuelaNotasMaterias;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaNotasMaterias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceEscuelaNotasMateriasCreate {

  @Autowired
  private IRepositoryEscuelaNotasMaterias repositoryEscuelaNotasMaterias;

  /** method for create. */
  public ResponseEntity<String> create(DtoEscuelaNotasMaterias dtoEscuelaNotasMaterias) {
    try {
      EntityEscuelaNotasMaterias entity = repositoryEscuelaNotasMaterias.save(dtoEscuelaNotasMaterias.dtoToEntity());
      DtoEscuelaNotasMaterias dto = DtoEscuelaNotasMaterias.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
