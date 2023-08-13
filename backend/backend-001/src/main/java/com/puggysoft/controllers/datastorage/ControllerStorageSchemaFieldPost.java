package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaField;
import com.puggysoft.services.datastorage.ServiceStorageSchemaFieldCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaFieldPost {
  @Autowired
  private ServiceStorageSchemaFieldCreate serviceStorageSchemaFieldCreate;

  @PostMapping(path = "/api/v1/storage-schema-field")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoStorageSchemaField dtoStorageSchemaField) {
    return serviceStorageSchemaFieldCreate.create(dtoStorageSchemaField);
  }
}