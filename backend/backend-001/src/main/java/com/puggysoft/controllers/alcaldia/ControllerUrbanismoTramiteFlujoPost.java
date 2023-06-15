package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujo;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteFlujoCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteFlujoPost {
  @Autowired
  private ServiceUrbanismoTramiteFlujoCreate serviceUrbanismoTramiteFlujoCreate;

  @PostMapping(path = "/api/v1/urbanismo-tramite-flujo")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoUrbanismoTramiteFlujo dtoUrbanismoTramiteFlujo) {
    return serviceUrbanismoTramiteFlujoCreate.create(dtoUrbanismoTramiteFlujo);
  }
}