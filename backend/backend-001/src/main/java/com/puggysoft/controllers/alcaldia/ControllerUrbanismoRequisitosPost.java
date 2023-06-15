package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitos;
import com.puggysoft.services.alcaldia.ServiceUrbanismoRequisitosCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoRequisitosPost {
  @Autowired
  private ServiceUrbanismoRequisitosCreate serviceUrbanismoRequisitosCreate;

  @PostMapping(path = "/api/v1/urbanismo-requisitos")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoUrbanismoRequisitos dtoUrbanismoRequisitos) {
    return serviceUrbanismoRequisitosCreate.create(dtoUrbanismoRequisitos);
  }
}