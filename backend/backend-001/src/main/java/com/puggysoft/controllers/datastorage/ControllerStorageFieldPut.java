package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageField;
import com.puggysoft.services.datastorage.ServiceStorageFieldEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageFieldPut {

  @Autowired
  private ServiceStorageFieldEditById serviceStorageFieldEditById;

  @PutMapping(path = "/api/v1/storage-field/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoStorageField dtoStorageField) {
    return serviceStorageFieldEditById.editById(id, dtoStorageField);
  }
}
