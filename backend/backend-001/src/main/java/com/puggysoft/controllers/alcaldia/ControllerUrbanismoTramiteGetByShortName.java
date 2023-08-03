package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteGetByShortName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteGetByShortName {

  @Autowired
  private ServiceUrbanismoTramiteGetByShortName service;

  @GetMapping(path = "/api/v1/urbanismo-tramites-buscar")
  public ResponseEntity<DtoUrbanismoTramite> getById(@RequestParam String shortName) {
    return service.getByShortName(shortName);
  }
}
