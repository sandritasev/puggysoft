package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorial;
import com.puggysoft.services.pets.ServicePetsHistorialGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsHistorialGetById {

  @Autowired
  private ServicePetsHistorialGetById servicePetsHistorialGetById;

  @GetMapping(path = "/api/v1/pets-historial/{id}")
  public ResponseEntity<DtoPetsHistorial> getById(@PathVariable Long id) {
    return servicePetsHistorialGetById.getById(id);
  }
}