package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.services.alcaldia.ServiceUrbanismoEstadosGetAll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerUrbanismoEstadosGetAll {

  @Autowired
  private ServiceUrbanismoEstadosGetAll serviceUrbanismoEstadosGetAll;

  @GetMapping(path = "/api/v1/urbanismo-estados")
  public ResponseEntity<List<DtoUrbanismoEstados>> getAll() {
    return serviceUrbanismoEstadosGetAll.getAll();
  }
}