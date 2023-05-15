package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorial;
import com.puggysoft.entities.pets.EntityPetsHistorial;
import com.puggysoft.repositories.pets.IRepositoryPetsHistorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServicePetsHistorialCreate {

  @Autowired
  private IRepositoryPetsHistorial repositoryPetsHistorial;

  /** method for create. */
  public ResponseEntity<String> create(DtoPetsHistorial dtoPetsHistorial) {
    try {
      EntityPetsHistorial entity = repositoryPetsHistorial.save(dtoPetsHistorial.dtoToEntity());
      DtoPetsHistorial dto = DtoPetsHistorial.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}