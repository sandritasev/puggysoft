package com.puggysoft.controllers.escuela;

import com.puggysoft.services.escuela.ServiceEscuelaCursosDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosDeleteById {

  @Autowired
  private ServiceEscuelaCursosDeleteById serviceEscuelaCursosDeleteById;

  @DeleteMapping(path = "/api/v1/escuela-cursos/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceEscuelaCursosDeleteById.deleteById(id);
  }
}