package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecord;
import com.puggysoft.entities.datastorage.EntityStorageRecord;
import com.puggysoft.repositories.datastorage.IRepositoryStorageRecord;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceStorageRecordGetById {

  @Autowired
  private IRepositoryStorageRecord repositoryStorageRecord;

  /** method for retrive. */
  public ResponseEntity<DtoStorageRecord> getById(Long id) {
    Optional<EntityStorageRecord> optionalEntity = repositoryStorageRecord.findById(id);
    if (optionalEntity.isPresent()) {
      DtoStorageRecord dtoControl = DtoStorageRecord.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}