package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorial;
import com.puggysoft.services.pets.ServicePetsHistorialCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsHistorialPost {
  @Autowired
  private ServicePetsHistorialCreate servicePetsHistorialCreate;

  @PostMapping(path = "/api/v1/pets-historial")
  public ResponseEntity<String> post(@RequestBody @Valid DtoPetsHistorial dtoPetsHistorial) {
    return servicePetsHistorialCreate.create(dtoPetsHistorial);
  }
}