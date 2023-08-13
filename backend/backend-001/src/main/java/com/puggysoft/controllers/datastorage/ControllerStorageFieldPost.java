package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageField;
import com.puggysoft.services.datastorage.ServiceStorageFieldCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageFieldPost {
  @Autowired
  private ServiceStorageFieldCreate serviceStorageFieldCreate;

  @PostMapping(path = "/api/v1/storage-field")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoStorageField dtoStorageField) {
    return serviceStorageFieldCreate.create(dtoStorageField);
  }
}