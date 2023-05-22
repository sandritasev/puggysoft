package com.puggysoft.controllers.escuela;

import com.puggysoft.services.escuela.ServiceEscuelaNotasMateriasDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaNotasMateriasDeleteById {

  @Autowired
  private ServiceEscuelaNotasMateriasDeleteById serviceEscuelaNotasMateriasDeleteById;

  @DeleteMapping(path = "/api/v1/escuela-notas-materias/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceEscuelaNotasMateriasDeleteById.deleteById(id);
  }
}