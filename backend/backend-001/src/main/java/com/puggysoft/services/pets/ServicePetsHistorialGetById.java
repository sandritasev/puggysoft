package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorial;
import com.puggysoft.entities.pets.EntityPetsHistorial;
import com.puggysoft.repositories.pets.IRepositoryPetsHistorial;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServicePetsHistorialGetById {

  @Autowired
  private IRepositoryPetsHistorial repositoryPetsHistorial;

  /** method for retrive. */
  public ResponseEntity<DtoPetsHistorial> getById(Long id) {
    Optional<EntityPetsHistorial> optionalEntity = repositoryPetsHistorial.findById(id);
    if (optionalEntity.isPresent()) {
      DtoPetsHistorial dtoControl = DtoPetsHistorial.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}
