package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.entities.alcaldia.EntityUrbanismoEstados;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoEstados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceUrbanismoEstadosCreate {

  @Autowired
  private IRepositoryUrbanismoEstados repositoryUrbanismoEstados;

  /** method for create. */
  public ResponseEntity<String> create(DtoUrbanismoEstados dtoUrbanismoEstados) {
    try {
      EntityUrbanismoEstados entity = repositoryUrbanismoEstados
          .save(dtoUrbanismoEstados.dtoToEntity());
      DtoUrbanismoEstados dto = DtoUrbanismoEstados.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
