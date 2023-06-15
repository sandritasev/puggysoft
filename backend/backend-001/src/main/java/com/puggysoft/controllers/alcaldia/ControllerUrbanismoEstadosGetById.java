package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.services.alcaldia.ServiceUrbanismoEstadosGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoEstadosGetById {

  @Autowired
  private ServiceUrbanismoEstadosGetById serviceUrbanismoEstadosGetById;

  @GetMapping(path = "/api/v1/urbanismo-estados/{id}")
  public ResponseEntity<DtoUrbanismoEstados> getById(@PathVariable Long id) {
    return serviceUrbanismoEstadosGetById.getById(id);
  }
}
