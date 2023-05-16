package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPets;
import com.puggysoft.dtos.pets.DtoPetsFilter;
import com.puggysoft.services.pets.ServicePetsGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsGetFilter {

  @Autowired
  private ServicePetsGetFilter servicePetsGetFilter;

  @PostMapping(path = "/api/v1/pets/filter")
  public ResponseEntity<List<DtoPets>> getPetsFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoPetsFilter dtoPetsFilter) {
    return servicePetsGetFilter.filter(dtoPetsFilter, page, size);
  }
}