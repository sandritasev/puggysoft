package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageField;
import com.puggysoft.entities.datastorage.EntityStorageField;
import com.puggysoft.repositories.datastorage.IRepositoryStorageField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceStorageFieldCreate {

  @Autowired
  private IRepositoryStorageField repositoryStorageField;

  /** method for create. */
  public ResponseEntity<String> create(DtoStorageField dtoStorageField) {
    try {
      EntityStorageField entity = repositoryStorageField
          .save(dtoStorageField.dtoToEntity());
      DtoStorageField dto = DtoStorageField.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
