package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorialFilter;
import com.puggysoft.services.pets.ServicePetsHistorialGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsHistorialGetFilterSize {

  @Autowired
  private ServicePetsHistorialGetFilterSize servicePetsHistorialGetFilterSize;

  @PostMapping(path = "/api/v1/pets-historial/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoPetsHistorialFilter dtoPetsHistorialFilter,
      @PathVariable Long pageSize) {
    return servicePetsHistorialGetFilterSize.getSize(dtoPetsHistorialFilter, pageSize);
  }
}