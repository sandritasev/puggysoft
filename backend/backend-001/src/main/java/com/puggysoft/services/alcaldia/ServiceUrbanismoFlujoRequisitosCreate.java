package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoFlujoRequisitos;
import com.puggysoft.entities.alcaldia.EntityUrbanismoFlujoRequisitos;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoFlujoRequisitos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceUrbanismoFlujoRequisitosCreate {

  @Autowired
  private IRepositoryUrbanismoFlujoRequisitos repositoryUrbanismoFlujoRequisitos;

  /** method for create. */
  public ResponseEntity<String> create(DtoUrbanismoFlujoRequisitos dtoUrbanismoFlujoRequisitos) {
    try {
      EntityUrbanismoFlujoRequisitos entity = repositoryUrbanismoFlujoRequisitos
          .save(dtoUrbanismoFlujoRequisitos.dtoToEntity());
      DtoUrbanismoFlujoRequisitos dto = DtoUrbanismoFlujoRequisitos.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
