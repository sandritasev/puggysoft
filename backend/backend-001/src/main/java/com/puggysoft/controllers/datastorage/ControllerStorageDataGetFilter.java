package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageData;
import com.puggysoft.dtos.datastorage.DtoStorageDataFilter;
import com.puggysoft.services.datastorage.ServiceStorageDataGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStorageDataGetFilter {

  @Autowired
  private ServiceStorageDataGetFilter serviceStorageDataGetFilter;

  @PostMapping(path = "/api/v1/storage-data/filter")
  public ResponseEntity<List<DtoStorageData>> getStorageDataFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoStorageDataFilter dtoStorageDataFilter) {
    return serviceStorageDataGetFilter.filter(dtoStorageDataFilter, page, size);
  }
}