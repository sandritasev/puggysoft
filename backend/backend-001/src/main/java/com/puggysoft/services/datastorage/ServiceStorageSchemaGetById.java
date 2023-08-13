package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchema;
import com.puggysoft.entities.datastorage.EntityStorageSchema;
import com.puggysoft.repositories.datastorage.IRepositoryStorageSchema;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceStorageSchemaGetById {

  @Autowired
  private IRepositoryStorageSchema repositoryStorageSchema;

  /** method for retrive. */
  public ResponseEntity<DtoStorageSchema> getById(Long id) {
    Optional<EntityStorageSchema> optionalEntity = repositoryStorageSchema.findById(id);
    if (optionalEntity.isPresent()) {
      DtoStorageSchema dtoControl = DtoStorageSchema.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}