package com.puggysoft.controllers.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageField;
import com.puggysoft.services.datastorage.ServiceStorageFieldGetBySchema;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerStorageFieldGetBySchema {

  @Autowired
  private ServiceStorageFieldGetBySchema service;

  // /api/v1/storage-field-by-schema?schemaShortName=Example
  @GetMapping(path = "/api/v1/storage-field-by-schema")
  public ResponseEntity<List<DtoStorageField>> getBySchema(@RequestParam String schemaShortName) {
    return service.getBySchema(schemaShortName);
  }
}