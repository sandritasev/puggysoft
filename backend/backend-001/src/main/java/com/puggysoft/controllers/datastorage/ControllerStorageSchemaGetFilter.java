package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchema;
import com.puggysoft.dtos.datastorage.DtoStorageSchemaFilter;
import com.puggysoft.services.datastorage.ServiceStorageSchemaGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaGetFilter {

  @Autowired
  private ServiceStorageSchemaGetFilter serviceStorageSchemaGetFilter;

  @PostMapping(path = "/api/v1/storage-schema/filter")
  public ResponseEntity<List<DtoStorageSchema>> getStorageSchemaFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoStorageSchemaFilter dtoStorageSchemaFilter) {
    return serviceStorageSchemaGetFilter.filter(dtoStorageSchemaFilter, page, size);
  }
}