package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchema;
import com.puggysoft.repositories.datastorage.IRepositoryStorageSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceStorageSchemaEditById {

  @Autowired
  private IRepositoryStorageSchema repositoryStorageSchema;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoStorageSchema dtoStorageSchema) {
    if (repositoryStorageSchema.existsById(id)) {
      try {
        dtoStorageSchema.setId(id.longValue());
        repositoryStorageSchema.save(dtoStorageSchema.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}