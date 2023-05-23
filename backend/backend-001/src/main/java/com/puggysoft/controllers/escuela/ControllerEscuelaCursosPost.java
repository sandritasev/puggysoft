package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursos;
import com.puggysoft.services.escuela.ServiceEscuelaCursosCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosPost {
  @Autowired
  private ServiceEscuelaCursosCreate serviceEscuelaCursosCreate;

  @PostMapping(path = "/api/v1/escuela-cursos")
  public ResponseEntity<String> post(@RequestBody @Valid DtoEscuelaCursos dtoEscuelaCursos) {
    return serviceEscuelaCursosCreate.create(dtoEscuelaCursos);
  }
}