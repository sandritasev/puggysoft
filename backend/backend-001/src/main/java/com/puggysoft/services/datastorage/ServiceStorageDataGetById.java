package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageData;
import com.puggysoft.entities.datastorage.EntityStorageData;
import com.puggysoft.repositories.datastorage.IRepositoryStorageData;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceStorageDataGetById {

  @Autowired
  private IRepositoryStorageData repositoryStorageData;

  /** method for retrive. */
  public ResponseEntity<DtoStorageData> getById(Long id) {
    Optional<EntityStorageData> optionalEntity = repositoryStorageData.findById(id);
    if (optionalEntity.isPresent()) {
      DtoStorageData dtoControl = DtoStorageData.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}