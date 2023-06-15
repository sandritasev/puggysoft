package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceUrbanismoTramiteEditById {

  @Autowired
  private IRepositoryUrbanismoTramite repositoryUrbanismoTramite;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoUrbanismoTramite dtoUrbanismoTramite) {
    if (repositoryUrbanismoTramite.existsById(id)) {
      try {
        dtoUrbanismoTramite.setId(id.longValue());
        repositoryUrbanismoTramite.save(dtoUrbanismoTramite.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}