package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursosEstudiantes;
import com.puggysoft.services.escuela.ServiceEscuelaCursosEstudiantesCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosEstudiantesPost {
  @Autowired
  private ServiceEscuelaCursosEstudiantesCreate serviceEscuelaCursosEstudiantesCreate;

  @PostMapping(path = "/api/v1/escuela-cursos-estudiantes")
  public ResponseEntity<String> post(@RequestBody @Valid DtoEscuelaCursosEstudiantes dtoEscuelaCursosEstudiantes) {
    return serviceEscuelaCursosEstudiantesCreate.create(dtoEscuelaCursosEstudiantes);
  }
}