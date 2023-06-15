package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoHistorial;
import com.puggysoft.services.alcaldia.ServiceUrbanismoHistorialCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoHistorialPost {
  @Autowired
  private ServiceUrbanismoHistorialCreate serviceUrbanismoHistorialCreate;

  @PostMapping(path = "/api/v1/urbanismo-historial")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoUrbanismoHistorial dtoUrbanismoHistorial) {
    return serviceUrbanismoHistorialCreate.create(dtoUrbanismoHistorial);
  }
}