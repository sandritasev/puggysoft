package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageField;
import com.puggysoft.entities.datastorage.EntityStorageField;
import com.puggysoft.repositories.datastorage.IRepositoryStorageField;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceStorageFieldGetById {

  @Autowired
  private IRepositoryStorageField repositoryStorageField;

  /** method for retrive. */
  public ResponseEntity<DtoStorageField> getById(Long id) {
    Optional<EntityStorageField> optionalEntity = repositoryStorageField.findById(id);
    if (optionalEntity.isPresent()) {
      DtoStorageField dtoControl = DtoStorageField.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}