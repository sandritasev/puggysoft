package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPets;
import com.puggysoft.services.pets.ServicePetsGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsGetById {

  @Autowired
  private ServicePetsGetById servicePetsGetById;

  @GetMapping(path = "/api/v1/pets/{id}")
  public ResponseEntity<DtoPets> getById(@PathVariable Long id) {
    return servicePetsGetById.getById(id);
  }
}
