package com.puggysoft.controllers.system;

import com.puggysoft.services.system.ServiceTenantPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ControllerTenantPostPicture {

  @Autowired
  private ServiceTenantPicture servicePicture;

  // id is TenantId
  @PostMapping(path = "/api/v1/tenants/picture")
  public ResponseEntity<String> post(@RequestParam("file") MultipartFile file,  @RequestParam Long id) {
    return servicePicture.setPicture(file, id);
  }
}
