package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageField;
import com.puggysoft.services.datastorage.ServiceStorageFieldGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageFieldGetById {

  @Autowired
  private ServiceStorageFieldGetById serviceStorageFieldGetById;

  @GetMapping(path = "/api/v1/storage-field/{id}")
  public ResponseEntity<DtoStorageField> getById(@PathVariable Long id) {
    return serviceStorageFieldGetById.getById(id);
  }
}
