package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPets;
import com.puggysoft.entities.pets.EntityPets;
import com.puggysoft.repositories.pets.IRepositoryPets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServicePetsCreate {

  @Autowired
  private IRepositoryPets repositoryPets;

  /** method for create. */
  public ResponseEntity<String> create(DtoPets dtoPets) {
    try {
      EntityPets entity = repositoryPets.save(dtoPets.dtoToEntity());
      DtoPets dto = DtoPets.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
