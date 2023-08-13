package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaField;
import com.puggysoft.services.datastorage.ServiceStorageSchemaFieldEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaFieldPut {

  @Autowired
  private ServiceStorageSchemaFieldEditById serviceStorageSchemaFieldEditById;

  @PutMapping(path = "/api/v1/storage-schema-field/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoStorageSchemaField dtoStorageSchemaField) {
    return serviceStorageSchemaFieldEditById.editById(id, dtoStorageSchemaField);
  }
}
