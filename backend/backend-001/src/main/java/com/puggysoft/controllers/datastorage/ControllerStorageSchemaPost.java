package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchema;
import com.puggysoft.services.datastorage.ServiceStorageSchemaCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaPost {
  @Autowired
  private ServiceStorageSchemaCreate serviceStorageSchemaCreate;

  @PostMapping(path = "/api/v1/storage-schema")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoStorageSchema dtoStorageSchema) {
    return serviceStorageSchemaCreate.create(dtoStorageSchema);
  }
}