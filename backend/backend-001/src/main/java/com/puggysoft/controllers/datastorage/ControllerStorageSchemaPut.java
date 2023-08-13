package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchema;
import com.puggysoft.services.datastorage.ServiceStorageSchemaEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaPut {

  @Autowired
  private ServiceStorageSchemaEditById serviceStorageSchemaEditById;

  @PutMapping(path = "/api/v1/storage-schema/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoStorageSchema dtoStorageSchema) {
    return serviceStorageSchemaEditById.editById(id, dtoStorageSchema);
  }
}
