package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramitePut {

  @Autowired
  private ServiceUrbanismoTramiteEditById serviceUrbanismoTramiteEditById;

  @PutMapping(path = "/api/v1/urbanismo-tramite/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoUrbanismoTramite dtoUrbanismoTramite) {
    return serviceUrbanismoTramiteEditById.editById(id, dtoUrbanismoTramite);
  }
}
