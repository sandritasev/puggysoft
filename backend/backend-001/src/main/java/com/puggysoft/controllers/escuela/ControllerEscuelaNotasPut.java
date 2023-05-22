package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotas;
import com.puggysoft.services.escuela.ServiceEscuelaNotasEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaNotasPut {

  @Autowired
  private ServiceEscuelaNotasEditById serviceEscuelaNotasEditById;

  @PutMapping(path = "/api/v1/escuela-notas/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoEscuelaNotas dtoEscuelaNotas) {
    return serviceEscuelaNotasEditById.editById(id, dtoEscuelaNotas);
  }
}
