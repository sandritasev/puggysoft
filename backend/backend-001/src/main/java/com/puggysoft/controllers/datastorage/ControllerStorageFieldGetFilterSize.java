package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageFieldFilter;
import com.puggysoft.services.datastorage.ServiceStorageFieldGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageFieldGetFilterSize {

  @Autowired
  private ServiceStorageFieldGetFilterSize serviceStorageFieldGetFilterSize;

  @PostMapping(path = "/api/v1/storage-field/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoStorageFieldFilter dtoStorageFieldFilter,
      @PathVariable Long pageSize) {
    return serviceStorageFieldGetFilterSize.getSize(dtoStorageFieldFilter, pageSize);
  }
}