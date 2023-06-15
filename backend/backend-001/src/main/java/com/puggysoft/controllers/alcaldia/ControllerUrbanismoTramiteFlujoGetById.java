package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujo;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteFlujoGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteFlujoGetById {

  @Autowired
  private ServiceUrbanismoTramiteFlujoGetById serviceUrbanismoTramiteFlujoGetById;

  @GetMapping(path = "/api/v1/urbanismo-tramite-flujo/{id}")
  public ResponseEntity<DtoUrbanismoTramiteFlujo> getById(@PathVariable Long id) {
    return serviceUrbanismoTramiteFlujoGetById.getById(id);
  }
}
