package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.services.alcaldia.ServiceUrbanismoEstadosCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoEstadosPost {
  @Autowired
  private ServiceUrbanismoEstadosCreate serviceUrbanismoEstadosCreate;

  @PostMapping(path = "/api/v1/urbanismo-estados")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoUrbanismoEstados dtoUrbanismoEstados) {
    return serviceUrbanismoEstadosCreate.create(dtoUrbanismoEstados);
  }
}