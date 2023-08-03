package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.services.alcaldia.ServiceUrbanismoEstadosGetByShortName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoEstadosGetByShortName {

  @Autowired
  private ServiceUrbanismoEstadosGetByShortName service;

  @GetMapping(path = "/api/v1/urbanismo-estados-buscar")
  public ResponseEntity<DtoUrbanismoEstados> getByShortName(@RequestParam String shortName) {
    return service.getByShortName(shortName);
  }
}
