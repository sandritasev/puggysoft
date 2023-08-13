package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageData;
import com.puggysoft.services.datastorage.ServiceStorageDataGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageDataGetById {

  @Autowired
  private ServiceStorageDataGetById serviceStorageDataGetById;

  @GetMapping(path = "/api/v1/storage-data/{id}")
  public ResponseEntity<DtoStorageData> getById(@PathVariable Long id) {
    return serviceStorageDataGetById.getById(id);
  }
}
