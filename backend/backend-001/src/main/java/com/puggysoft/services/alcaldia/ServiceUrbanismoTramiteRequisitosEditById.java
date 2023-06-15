package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteRequisitos;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramiteRequisitos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceUrbanismoTramiteRequisitosEditById {

  @Autowired
  private IRepositoryUrbanismoTramiteRequisitos repositoryUrbanismoTramiteRequisitos;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoUrbanismoTramiteRequisitos dtoUrbanismoTramiteRequisitos) {
    if (repositoryUrbanismoTramiteRequisitos.existsById(id)) {
      try {
        dtoUrbanismoTramiteRequisitos.setId(id.longValue());
        repositoryUrbanismoTramiteRequisitos.save(dtoUrbanismoTramiteRequisitos.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}