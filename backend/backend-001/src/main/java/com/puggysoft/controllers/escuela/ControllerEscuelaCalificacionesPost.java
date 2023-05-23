package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCalificaciones;
import com.puggysoft.services.escuela.ServiceEscuelaCalificacionesCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCalificacionesPost {
  @Autowired
  private ServiceEscuelaCalificacionesCreate serviceEscuelaCalificacionesCreate;

  @PostMapping(path = "/api/v1/escuela-calificaciones")
  public ResponseEntity<String> post(@RequestBody @Valid DtoEscuelaCalificaciones dtoEscuelaCalificaciones) {
    return serviceEscuelaCalificacionesCreate.create(dtoEscuelaCalificaciones);
  }
}