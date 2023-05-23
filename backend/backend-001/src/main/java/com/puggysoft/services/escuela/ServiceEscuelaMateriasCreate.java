package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaMaterias;
import com.puggysoft.entities.escuela.EntityEscuelaMaterias;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaMaterias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceEscuelaMateriasCreate {

  @Autowired
  private IRepositoryEscuelaMaterias repositoryEscuelaMaterias;

  /** method for create. */
  public ResponseEntity<String> create(DtoEscuelaMaterias dtoEscuelaMaterias) {
    try {
      EntityEscuelaMaterias entity = repositoryEscuelaMaterias.save(dtoEscuelaMaterias.dtoToEntity());
      DtoEscuelaMaterias dto = DtoEscuelaMaterias.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
