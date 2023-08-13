package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageData;
import com.puggysoft.services.datastorage.ServiceStorageDataCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageDataPost {
  @Autowired
  private ServiceStorageDataCreate serviceStorageDataCreate;

  @PostMapping(path = "/api/v1/storage-data")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoStorageData dtoStorageData) {
    return serviceStorageDataCreate.create(dtoStorageData);
  }
}