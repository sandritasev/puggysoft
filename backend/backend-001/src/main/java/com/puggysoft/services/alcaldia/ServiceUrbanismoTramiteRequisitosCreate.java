package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteRequisitos;
import com.puggysoft.entities.alcaldia.EntityUrbanismoTramiteRequisitos;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramiteRequisitos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceUrbanismoTramiteRequisitosCreate {

  @Autowired
  private IRepositoryUrbanismoTramiteRequisitos repositoryUrbanismoTramiteRequisitos;

  /** method for create. */
  public ResponseEntity<String> create(DtoUrbanismoTramiteRequisitos dtoUrbanismoTramiteRequisitos) {
    try {
      EntityUrbanismoTramiteRequisitos entity = repositoryUrbanismoTramiteRequisitos
          .save(dtoUrbanismoTramiteRequisitos.dtoToEntity());
      DtoUrbanismoTramiteRequisitos dto = DtoUrbanismoTramiteRequisitos.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
