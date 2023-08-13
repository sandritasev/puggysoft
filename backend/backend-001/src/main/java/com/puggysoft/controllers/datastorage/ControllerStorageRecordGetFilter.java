package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecord;
import com.puggysoft.dtos.datastorage.DtoStorageRecordFilter;
import com.puggysoft.services.datastorage.ServiceStorageRecordGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageRecordGetFilter {

  @Autowired
  private ServiceStorageRecordGetFilter serviceStorageRecordGetFilter;

  @PostMapping(path = "/api/v1/storage-record/filter")
  public ResponseEntity<List<DtoStorageRecord>> getStorageRecordFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoStorageRecordFilter dtoStorageRecordFilter) {
    return serviceStorageRecordGetFilter.filter(dtoStorageRecordFilter, page, size);
  }
}