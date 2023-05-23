package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotas;
import com.puggysoft.services.escuela.ServiceEscuelaNotasCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaNotasPost {
  @Autowired
  private ServiceEscuelaNotasCreate serviceEscuelaNotasCreate;

  @PostMapping(path = "/api/v1/escuela-notas")
  public ResponseEntity<String> post(@RequestBody @Valid DtoEscuelaNotas dtoEscuelaNotas) {
    return serviceEscuelaNotasCreate.create(dtoEscuelaNotas);
  }
}