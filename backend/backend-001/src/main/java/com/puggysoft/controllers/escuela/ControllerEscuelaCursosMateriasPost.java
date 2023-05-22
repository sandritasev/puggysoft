package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursosMaterias;
import com.puggysoft.services.escuela.ServiceEscuelaCursosMateriasCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosMateriasPost {
  @Autowired
  private ServiceEscuelaCursosMateriasCreate serviceEscuelaCursosMateriasCreate;

  @PostMapping(path = "/api/v1/escuela-cursos-materias")
  public ResponseEntity<String> post(@RequestBody @Valid DtoEscuelaCursosMaterias dtoEscuelaCursosMaterias) {
    return serviceEscuelaCursosMateriasCreate.create(dtoEscuelaCursosMaterias);
  }
}