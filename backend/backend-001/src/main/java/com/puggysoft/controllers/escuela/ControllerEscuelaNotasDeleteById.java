package com.puggysoft.controllers.escuela;

import com.puggysoft.services.escuela.ServiceEscuelaNotasDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaNotasDeleteById {

  @Autowired
  private ServiceEscuelaNotasDeleteById serviceEscuelaNotasDeleteById;

  @DeleteMapping(path = "/api/v1/escuela-notas/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceEscuelaNotasDeleteById.deleteById(id);
  }
}