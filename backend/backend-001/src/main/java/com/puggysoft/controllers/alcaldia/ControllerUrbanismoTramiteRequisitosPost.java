package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteRequisitos;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteRequisitosCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteRequisitosPost {
  @Autowired
  private ServiceUrbanismoTramiteRequisitosCreate serviceUrbanismoTramiteRequisitosCreate;

  @PostMapping(path = "/api/v1/urbanismo-tramite-requisitos")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoUrbanismoTramiteRequisitos dtoUrbanismoTramiteRequisitos) {
    return serviceUrbanismoTramiteRequisitosCreate.create(dtoUrbanismoTramiteRequisitos);
  }
}