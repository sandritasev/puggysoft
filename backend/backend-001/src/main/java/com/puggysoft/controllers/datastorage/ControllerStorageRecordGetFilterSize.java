package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecordFilter;
import com.puggysoft.services.datastorage.ServiceStorageRecordGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageRecordGetFilterSize {

  @Autowired
  private ServiceStorageRecordGetFilterSize serviceStorageRecordGetFilterSize;

  @PostMapping(path = "/api/v1/storage-record/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoStorageRecordFilter dtoStorageRecordFilter,
      @PathVariable Long pageSize) {
    return serviceStorageRecordGetFilterSize.getSize(dtoStorageRecordFilter, pageSize);
  }
}