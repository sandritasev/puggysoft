package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecord;
import com.puggysoft.services.datastorage.ServiceStorageRecordGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageRecordGetById {

  @Autowired
  private ServiceStorageRecordGetById serviceStorageRecordGetById;

  @GetMapping(path = "/api/v1/storage-record/{id}")
  public ResponseEntity<DtoStorageRecord> getById(@PathVariable Long id) {
    return serviceStorageRecordGetById.getById(id);
  }
}
