package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteGetById {

  @Autowired
  private ServiceUrbanismoTramiteGetById serviceUrbanismoTramiteGetById;

  @GetMapping(path = "/api/v1/urbanismo-tramite/{id}")
  public ResponseEntity<DtoUrbanismoTramite> getById(@PathVariable Long id) {
    return serviceUrbanismoTramiteGetById.getById(id);
  }
}
