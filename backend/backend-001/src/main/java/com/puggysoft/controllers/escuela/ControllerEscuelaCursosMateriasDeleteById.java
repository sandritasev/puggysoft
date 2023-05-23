package com.puggysoft.controllers.escuela;

import com.puggysoft.services.escuela.ServiceEscuelaCursosMateriasDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosMateriasDeleteById {

  @Autowired
  private ServiceEscuelaCursosMateriasDeleteById serviceEscuelaCursosMateriasDeleteById;

  @DeleteMapping(path = "/api/v1/escuela-cursos-materias/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceEscuelaCursosMateriasDeleteById.deleteById(id);
  }
}