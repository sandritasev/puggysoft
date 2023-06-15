package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.entities.alcaldia.EntityUrbanismoTramite;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceUrbanismoTramiteCreate {

  @Autowired
  private IRepositoryUrbanismoTramite repositoryUrbanismoTramite;

  /** method for create. */
  public ResponseEntity<String> create(DtoUrbanismoTramite dtoUrbanismoTramite) {
    try {
      EntityUrbanismoTramite entity = repositoryUrbanismoTramite
          .save(dtoUrbanismoTramite.dtoToEntity());
      DtoUrbanismoTramite dto = DtoUrbanismoTramite.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
