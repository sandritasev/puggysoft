package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchema;
import com.puggysoft.services.datastorage.ServiceStorageSchemaGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaGetById {

  @Autowired
  private ServiceStorageSchemaGetById serviceStorageSchemaGetById;

  @GetMapping(path = "/api/v1/storage-schema/{id}")
  public ResponseEntity<DtoStorageSchema> getById(@PathVariable Long id) {
    return serviceStorageSchemaGetById.getById(id);
  }
}
