package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageData;
import com.puggysoft.entities.datastorage.EntityStorageData;
import com.puggysoft.repositories.datastorage.IRepositoryStorageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceStorageDataCreate {

  @Autowired
  private IRepositoryStorageData repositoryStorageData;

  /** method for create. */
  public ResponseEntity<String> create(DtoStorageData dtoStorageData) {
    try {
      EntityStorageData entity = repositoryStorageData
          .save(dtoStorageData.dtoToEntity());
      DtoStorageData dto = DtoStorageData.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
