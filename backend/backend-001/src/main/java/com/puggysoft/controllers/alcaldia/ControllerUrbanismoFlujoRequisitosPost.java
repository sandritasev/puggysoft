package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoFlujoRequisitos;
import com.puggysoft.services.alcaldia.ServiceUrbanismoFlujoRequisitosCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoFlujoRequisitosPost {
  @Autowired
  private ServiceUrbanismoFlujoRequisitosCreate serviceUrbanismoFlujoRequisitosCreate;

  @PostMapping(path = "/api/v1/urbanismo-flujo-requisitos")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoUrbanismoFlujoRequisitos dtoUrbanismoFlujoRequisitos) {
    return serviceUrbanismoFlujoRequisitosCreate.create(dtoUrbanismoFlujoRequisitos);
  }
}