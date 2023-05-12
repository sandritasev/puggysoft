package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPets;
import com.puggysoft.services.pets.ServicePetsEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsPut {

  @Autowired
  private ServicePetsEditById servicePetsEditById;

  @PutMapping(path = "/api/v1/pets/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoPets dtoPets) {
    return servicePetsEditById.editById(id, dtoPets);
  }
}
