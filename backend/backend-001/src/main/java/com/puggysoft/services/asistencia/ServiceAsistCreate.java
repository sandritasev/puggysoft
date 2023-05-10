package com.puggysoft.services.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsist;
import com.puggysoft.entities.asistencia.EntityAsist;
import com.puggysoft.repositories.asistencia.IRepositoryAsist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceAsistCreate {

  @Autowired
  private IRepositoryAsist repositoryAsist;

  /** method for create. */
  public ResponseEntity<String> create(DtoAsist dtoAsist) {
    try {
      EntityAsist entity = repositoryAsist.save(dtoAsist.dtoToEntity());
      DtoAsist dto = DtoAsist.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
