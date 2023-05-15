package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPets;
import com.puggysoft.entities.pets.EntityPets;
import com.puggysoft.repositories.pets.IRepositoryPets;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServicePetsGetById {

  @Autowired
  private IRepositoryPets repositoryPets;

  /** method for retrive. */
  public ResponseEntity<DtoPets> getById(Long id) {
    Optional<EntityPets> optionalEntity = repositoryPets.findById(id);
    if (optionalEntity.isPresent()) {
      DtoPets dtoControl = DtoPets.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}