package com.puggysoft.controllers.datastorage;

import com.puggysoft.services.datastorage.ServiceStorageSchemaDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaDeleteById {

  @Autowired
  private ServiceStorageSchemaDeleteById serviceStorageSchemaDeleteById;

  @DeleteMapping(path = "/api/v1/storage-schema/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceStorageSchemaDeleteById.deleteById(id);
  }
}