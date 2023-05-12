package com.puggysoft.controllers.pets;

import com.puggysoft.services.pets.ServicePetsHistorialDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsHistorialDeleteById {

  @Autowired
  private ServicePetsHistorialDeleteById servicePetsHistorialDeleteById;

  @DeleteMapping(path = "/api/v1/pets-historial/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return servicePetsHistorialDeleteById.deleteById(id);
  }
}