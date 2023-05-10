package com.puggysoft.services.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsist;
import com.puggysoft.repositories.asistencia.IRepositoryAsist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceAsistEditById {

  @Autowired
  private IRepositoryAsist repositoryAsist;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoAsist dtoAsist) {
    if (repositoryAsist.existsById(id)) {
      try {
        dtoAsist.setId(id.longValue());
        repositoryAsist.save(dtoAsist.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}
