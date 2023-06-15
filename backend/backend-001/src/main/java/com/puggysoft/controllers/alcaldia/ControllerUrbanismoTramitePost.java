package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramitePost {
  @Autowired
  private ServiceUrbanismoTramiteCreate serviceUrbanismoTramiteCreate;

  @PostMapping(path = "/api/v1/urbanismo-tramite")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoUrbanismoTramite dtoUrbanismoTramite) {
    return serviceUrbanismoTramiteCreate.create(dtoUrbanismoTramite);
  }
}