package com.puggysoft.controllers.escuela;

import com.puggysoft.services.escuela.ServiceEscuelaCursosEstudiantesDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosEstudiantesDeleteById {

  @Autowired
  private ServiceEscuelaCursosEstudiantesDeleteById serviceEscuelaCursosEstudiantesDeleteById;

  @DeleteMapping(path = "/api/v1/escuela-cursos-estudiantes/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceEscuelaCursosEstudiantesDeleteById.deleteById(id);
  }
}