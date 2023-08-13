package com.puggysoft.controllers.datastorage;

import com.puggysoft.services.datastorage.ServiceStorageDataDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageDataDeleteById {

  @Autowired
  private ServiceStorageDataDeleteById serviceStorageDataDeleteById;

  @DeleteMapping(path = "/api/v1/storage-data/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceStorageDataDeleteById.deleteById(id);
  }
}