package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipales;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesPost {
  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesCreate serviceAlcaldiaRecursosMunicipalesCreate;

  @PostMapping(path = "/api/v1/alcaldia-recursos-municipales")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoAlcaldiaRecursosMunicipales dtoAlcaldiaRecursosMunicipales) {
    return serviceAlcaldiaRecursosMunicipalesCreate.create(dtoAlcaldiaRecursosMunicipales);
  }
}