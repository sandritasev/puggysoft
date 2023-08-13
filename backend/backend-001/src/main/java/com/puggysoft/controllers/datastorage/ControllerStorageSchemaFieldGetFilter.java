package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaField;
import com.puggysoft.dtos.datastorage.DtoStorageSchemaFieldFilter;
import com.puggysoft.services.datastorage.ServiceStorageSchemaFieldGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageSchemaFieldGetFilter {

  @Autowired
  private ServiceStorageSchemaFieldGetFilter serviceStorageSchemaFieldGetFilter;

  @PostMapping(path = "/api/v1/storage-schema-field/filter")
  public ResponseEntity<List<DtoStorageSchemaField>> getStorageSchemaFieldFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoStorageSchemaFieldFilter dtoStorageSchemaFieldFilter) {
    return serviceStorageSchemaFieldGetFilter.filter(dtoStorageSchemaFieldFilter, page, size);
  }
}