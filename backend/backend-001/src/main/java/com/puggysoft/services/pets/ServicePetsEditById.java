package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPets;
import com.puggysoft.repositories.pets.IRepositoryPets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServicePetsEditById {

  @Autowired
  private IRepositoryPets repositoryPets;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoPets dtoPets) {
    if (repositoryPets.existsById(id)) {
      try {
        dtoPets.setId(id.longValue());
        repositoryPets.save(dtoPets.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}