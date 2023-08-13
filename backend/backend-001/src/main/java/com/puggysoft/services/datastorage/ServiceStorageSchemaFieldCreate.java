package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaField;
import com.puggysoft.entities.datastorage.EntityStorageSchemaField;
import com.puggysoft.repositories.datastorage.IRepositoryStorageSchemaField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceStorageSchemaFieldCreate {

  @Autowired
  private IRepositoryStorageSchemaField repositoryStorageSchemaField;

  /** method for create. */
  public ResponseEntity<String> create(DtoStorageSchemaField dtoStorageSchemaField) {
    try {
      EntityStorageSchemaField entity = repositoryStorageSchemaField
          .save(dtoStorageSchemaField.dtoToEntity());
      DtoStorageSchemaField dto = DtoStorageSchemaField.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
