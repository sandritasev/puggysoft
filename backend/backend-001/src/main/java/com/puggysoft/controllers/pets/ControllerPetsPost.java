package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPets;
import com.puggysoft.services.pets.ServicePetsCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsPost {
  @Autowired
  private ServicePetsCreate servicePetsCreate;

  @PostMapping(path = "/api/v1/pets")
  public ResponseEntity<String> post(@RequestBody @Valid DtoPets dtoPets) {
    return servicePetsCreate.create(dtoPets);
  }
}