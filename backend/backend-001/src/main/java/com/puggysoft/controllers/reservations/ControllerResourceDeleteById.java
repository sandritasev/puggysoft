package com.puggysoft.controllers.reservations;

import com.puggysoft.services.reservations.ServiceResourceDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerResourceDeleteById {

  @Autowired
  private ServiceResourceDeleteById serviceResourceDeleteById;

  @DeleteMapping(path = "/api/v1/reservations-resources/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceResourceDeleteById.deleteById(id);
  }
}