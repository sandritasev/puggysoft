package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaField;
import com.puggysoft.services.datastorage.ServiceStorageSchemaFieldGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaFieldGetById {

  @Autowired
  private ServiceStorageSchemaFieldGetById serviceStorageSchemaFieldGetById;

  @GetMapping(path = "/api/v1/storage-schema-field/{id}")
  public ResponseEntity<DtoStorageSchemaField> getById(@PathVariable Long id) {
    return serviceStorageSchemaFieldGetById.getById(id);
  }
}
