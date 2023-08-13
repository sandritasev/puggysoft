package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchema;
import com.puggysoft.entities.datastorage.EntityStorageSchema;
import com.puggysoft.repositories.datastorage.IRepositoryStorageSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceStorageSchemaCreate {

  @Autowired
  private IRepositoryStorageSchema repositoryStorageSchema;

  /** method for create. */
  public ResponseEntity<String> create(DtoStorageSchema dtoStorageSchema) {
    try {
      EntityStorageSchema entity = repositoryStorageSchema
          .save(dtoStorageSchema.dtoToEntity());
      DtoStorageSchema dto = DtoStorageSchema.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
