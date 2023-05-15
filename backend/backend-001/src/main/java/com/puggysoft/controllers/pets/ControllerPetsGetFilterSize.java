package com.puggysoft.controllers.pets;

import com.puggysoft.dtos.pets.DtoPetsFilter;
import com.puggysoft.services.pets.ServicePetsGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPetsGetFilterSize {

  @Autowired
  private ServicePetsGetFilterSize servicePetsGetFilterSize;

  @PostMapping(path = "/api/v1/pets/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoPetsFilter dtoPetsFilter, @PathVariable Long pageSize) {
    return servicePetsGetFilterSize.getSize(dtoPetsFilter, pageSize);
  }
}