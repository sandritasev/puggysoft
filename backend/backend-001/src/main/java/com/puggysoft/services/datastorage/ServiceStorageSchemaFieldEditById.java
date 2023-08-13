package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaField;
import com.puggysoft.repositories.datastorage.IRepositoryStorageSchemaField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceStorageSchemaFieldEditById {

  @Autowired
  private IRepositoryStorageSchemaField repositoryStorageSchemaField;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoStorageSchemaField dtoStorageSchemaField) {
    if (repositoryStorageSchemaField.existsById(id)) {
      try {
        dtoStorageSchemaField.setId(id.longValue());
        repositoryStorageSchemaField.save(dtoStorageSchemaField.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}