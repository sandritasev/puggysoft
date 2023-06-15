package com.puggysoft.controllers.alcaldia;

import com.puggysoft.services.alcaldia.ServiceUrbanismoHistorialDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoHistorialDeleteById {

  @Autowired
  private ServiceUrbanismoHistorialDeleteById serviceUrbanismoHistorialDeleteById;

  @DeleteMapping(path = "/api/v1/urbanismo-historial/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceUrbanismoHistorialDeleteById.deleteById(id);
  }
}