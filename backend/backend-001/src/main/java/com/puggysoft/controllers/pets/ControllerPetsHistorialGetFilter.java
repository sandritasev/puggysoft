package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorial;
import com.puggysoft.dtos.pets.DtoPetsHistorialFilter;
import com.puggysoft.services.pets.ServicePetsHistorialGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsHistorialGetFilter {

  @Autowired
  private ServicePetsHistorialGetFilter servicePetsHistorialGetFilter;

  @PostMapping(path = "/api/v1/pets-historial/filter")
  public ResponseEntity<List<DtoPetsHistorial>> getPetsHistorialFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoPetsHistorialFilter dtoPetsHistorialFilter) {
    return servicePetsHistorialGetFilter.filter(dtoPetsHistorialFilter, page, size);
  }
}