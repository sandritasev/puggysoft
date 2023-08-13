package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaFieldFilter;
import com.puggysoft.services.datastorage.ServiceStorageSchemaFieldGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaFieldGetFilterSize {

  @Autowired
  private ServiceStorageSchemaFieldGetFilterSize serviceStorageSchemaFieldGetFilterSize;

  @PostMapping(path = "/api/v1/storage-schema-field/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoStorageSchemaFieldFilter dtoStorageSchemaFieldFilter,
      @PathVariable Long pageSize) {
    return serviceStorageSchemaFieldGetFilterSize.getSize(dtoStorageSchemaFieldFilter, pageSize);
  }
}