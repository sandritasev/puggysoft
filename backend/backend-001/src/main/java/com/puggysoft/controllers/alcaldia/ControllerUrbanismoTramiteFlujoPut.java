package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujo;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteFlujoEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteFlujoPut {

  @Autowired
  private ServiceUrbanismoTramiteFlujoEditById serviceUrbanismoTramiteFlujoEditById;

  @PutMapping(path = "/api/v1/urbanismo-tramite-flujo/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoUrbanismoTramiteFlujo dtoUrbanismoTramiteFlujo) {
    return serviceUrbanismoTramiteFlujoEditById.editById(id, dtoUrbanismoTramiteFlujo);
  }
}
