package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecord;
import com.puggysoft.services.datastorage.ServiceStorageRecordCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageRecordPost {
  @Autowired
  private ServiceStorageRecordCreate serviceStorageRecordCreate;

  @PostMapping(path = "/api/v1/storage-record")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoStorageRecord dtoStorageRecord) {
    return serviceStorageRecordCreate.create(dtoStorageRecord);
  }
}