package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecord;
import com.puggysoft.services.datastorage.ServiceStorageRecordEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageRecordPut {

  @Autowired
  private ServiceStorageRecordEditById serviceStorageRecordEditById;

  @PutMapping(path = "/api/v1/storage-record/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoStorageRecord dtoStorageRecord) {
    return serviceStorageRecordEditById.editById(id, dtoStorageRecord);
  }
}
