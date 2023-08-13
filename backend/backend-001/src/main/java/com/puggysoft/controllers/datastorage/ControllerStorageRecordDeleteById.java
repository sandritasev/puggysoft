package com.puggysoft.controllers.datastorage;

import com.puggysoft.services.datastorage.ServiceStorageRecordDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageRecordDeleteById {

  @Autowired
  private ServiceStorageRecordDeleteById serviceStorageRecordDeleteById;

  @DeleteMapping(path = "/api/v1/storage-record/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceStorageRecordDeleteById.deleteById(id);
  }
}