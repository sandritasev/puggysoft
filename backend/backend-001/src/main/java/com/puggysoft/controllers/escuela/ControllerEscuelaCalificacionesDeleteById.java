package com.puggysoft.controllers.escuela;

import com.puggysoft.services.escuela.ServiceEscuelaCalificacionesDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCalificacionesDeleteById {

  @Autowired
  private ServiceEscuelaCalificacionesDeleteById serviceEscuelaCalificacionesDeleteById;

  @DeleteMapping(path = "/api/v1/escuela-calificaciones/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceEscuelaCalificacionesDeleteById.deleteById(id);
  }
}