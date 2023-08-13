package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaField;
import com.puggysoft.entities.datastorage.EntityStorageSchemaField;
import com.puggysoft.repositories.datastorage.IRepositoryStorageSchemaField;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceStorageSchemaFieldGetById {

  @Autowired
  private IRepositoryStorageSchemaField repositoryStorageSchemaField;

  /** method for retrive. */
  public ResponseEntity<DtoStorageSchemaField> getById(Long id) {
    Optional<EntityStorageSchemaField> optionalEntity = repositoryStorageSchemaField.findById(id);
    if (optionalEntity.isPresent()) {
      DtoStorageSchemaField dtoControl = DtoStorageSchemaField.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}