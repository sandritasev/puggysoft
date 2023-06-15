package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitos;
import com.puggysoft.entities.alcaldia.EntityUrbanismoRequisitos;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoRequisitos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceUrbanismoRequisitosCreate {

  @Autowired
  private IRepositoryUrbanismoRequisitos repositoryUrbanismoRequisitos;

  /** method for create. */
  public ResponseEntity<String> create(DtoUrbanismoRequisitos dtoUrbanismoRequisitos) {
    try {
      EntityUrbanismoRequisitos entity = repositoryUrbanismoRequisitos
          .save(dtoUrbanismoRequisitos.dtoToEntity());
      DtoUrbanismoRequisitos dto = DtoUrbanismoRequisitos.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
