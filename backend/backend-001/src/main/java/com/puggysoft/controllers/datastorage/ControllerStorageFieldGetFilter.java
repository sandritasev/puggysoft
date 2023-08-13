package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageField;
import com.puggysoft.dtos.datastorage.DtoStorageFieldFilter;
import com.puggysoft.services.datastorage.ServiceStorageFieldGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageFieldGetFilter {

  @Autowired
  private ServiceStorageFieldGetFilter serviceStorageFieldGetFilter;

  @PostMapping(path = "/api/v1/storage-field/filter")
  public ResponseEntity<List<DtoStorageField>> getStorageFieldFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoStorageFieldFilter dtoStorageFieldFilter) {
    return serviceStorageFieldGetFilter.filter(dtoStorageFieldFilter, page, size);
  }
}