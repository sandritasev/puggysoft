package com.puggysoft.controllers.pets;

import com.puggysoft.services.pets.ServicePetsDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsDeleteById {

  @Autowired
  private ServicePetsDeleteById servicePetsDeleteById;

  @DeleteMapping(path = "/api/v1/pets/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return servicePetsDeleteById.deleteById(id);
  }
}