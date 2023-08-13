package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageDataFilter;
import com.puggysoft.services.datastorage.ServiceStorageDataGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageDataGetFilterSize {

  @Autowired
  private ServiceStorageDataGetFilterSize serviceStorageDataGetFilterSize;

  @PostMapping(path = "/api/v1/storage-data/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoStorageDataFilter dtoStorageDataFilter,
      @PathVariable Long pageSize) {
    return serviceStorageDataGetFilterSize.getSize(dtoStorageDataFilter, pageSize);
  }
}