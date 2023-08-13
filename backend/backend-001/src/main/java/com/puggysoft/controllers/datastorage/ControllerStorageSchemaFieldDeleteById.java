package com.puggysoft.controllers.datastorage;

import com.puggysoft.services.datastorage.ServiceStorageSchemaFieldDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaFieldDeleteById {

  @Autowired
  private ServiceStorageSchemaFieldDeleteById serviceStorageSchemaFieldDeleteById;

  @DeleteMapping(path = "/api/v1/storage-schema-field/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceStorageSchemaFieldDeleteById.deleteById(id);
  }
}