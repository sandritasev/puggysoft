package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecord;
import com.puggysoft.entities.datastorage.EntityStorageRecord;
import com.puggysoft.repositories.datastorage.IRepositoryStorageRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceStorageRecordCreate {

  @Autowired
  private IRepositoryStorageRecord repositoryStorageRecord;

  /** method for create. */
  public ResponseEntity<String> create(DtoStorageRecord dtoStorageRecord) {
    try {
      EntityStorageRecord entity = repositoryStorageRecord
          .save(dtoStorageRecord.dtoToEntity());
      DtoStorageRecord dto = DtoStorageRecord.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
