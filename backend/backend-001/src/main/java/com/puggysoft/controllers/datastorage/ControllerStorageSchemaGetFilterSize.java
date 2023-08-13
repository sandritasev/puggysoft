package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaFilter;
import com.puggysoft.services.datastorage.ServiceStorageSchemaGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaGetFilterSize {

  @Autowired
  private ServiceStorageSchemaGetFilterSize serviceStorageSchemaGetFilterSize;

  @PostMapping(path = "/api/v1/storage-schema/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoStorageSchemaFilter dtoStorageSchemaFilter,
      @PathVariable Long pageSize) {
    return serviceStorageSchemaGetFilterSize.getSize(dtoStorageSchemaFilter, pageSize);
  }
}