package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorial;
import com.puggysoft.services.pets.ServicePetsHistorialEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsHistorialPut {

  @Autowired
  private ServicePetsHistorialEditById servicePetsHistorialEditById;

  @PutMapping(path = "/api/v1/pets-historial/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoPetsHistorial dtoPetsHistorial) {
    return servicePetsHistorialEditById.editById(id, dtoPetsHistorial);
  }
}
