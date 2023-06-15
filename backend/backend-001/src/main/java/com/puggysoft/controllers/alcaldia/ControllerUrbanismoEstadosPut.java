package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.services.alcaldia.ServiceUrbanismoEstadosEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoEstadosPut {

  @Autowired
  private ServiceUrbanismoEstadosEditById serviceUrbanismoEstadosEditById;

  @PutMapping(path = "/api/v1/urbanismo-estados/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoUrbanismoEstados dtoUrbanismoEstados) {
    return serviceUrbanismoEstadosEditById.editById(id, dtoUrbanismoEstados);
  }
}
