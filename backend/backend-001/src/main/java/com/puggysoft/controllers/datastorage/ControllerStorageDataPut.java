package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageData;
import com.puggysoft.services.datastorage.ServiceStorageDataEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageDataPut {

  @Autowired
  private ServiceStorageDataEditById serviceStorageDataEditById;

  @PutMapping(path = "/api/v1/storage-data/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoStorageData dtoStorageData) {
    return serviceStorageDataEditById.editById(id, dtoStorageData);
  }
}
