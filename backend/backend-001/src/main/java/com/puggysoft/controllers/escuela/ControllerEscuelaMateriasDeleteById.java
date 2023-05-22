package com.puggysoft.controllers.escuela;

import com.puggysoft.services.escuela.ServiceEscuelaMateriasDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaMateriasDeleteById {

  @Autowired
  private ServiceEscuelaMateriasDeleteById serviceEscuelaMateriasDeleteById;

  @DeleteMapping(path = "/api/v1/escuela-materias/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceEscuelaMateriasDeleteById.deleteById(id);
  }
}