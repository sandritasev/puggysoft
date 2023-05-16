package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResResource;
import com.puggysoft.services.reservations.ServiceResourceEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerResourcePut {

  @Autowired
  private ServiceResourceEditById serviceResourceEditById;

  @PutMapping(path = "/api/v1/reservations-resources/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoResResource dtoResResource) {
    return serviceResourceEditById.editById(id, dtoResResource);
  }
}