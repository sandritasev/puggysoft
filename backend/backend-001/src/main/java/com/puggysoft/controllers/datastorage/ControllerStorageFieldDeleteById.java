package com.puggysoft.controllers.datastorage;

import com.puggysoft.services.datastorage.ServiceStorageFieldDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageFieldDeleteById {

  @Autowired
  private ServiceStorageFieldDeleteById serviceStorageFieldDeleteById;

  @DeleteMapping(path = "/api/v1/storage-field/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceStorageFieldDeleteById.deleteById(id);
  }
}