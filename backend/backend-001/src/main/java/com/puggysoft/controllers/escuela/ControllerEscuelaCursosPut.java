package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursos;
import com.puggysoft.services.escuela.ServiceEscuelaCursosEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosPut {

  @Autowired
  private ServiceEscuelaCursosEditById serviceEscuelaCursosEditById;

  @PutMapping(path = "/api/v1/escuela-cursos/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoEscuelaCursos dtoEscuelaCursos) {
    return serviceEscuelaCursosEditById.editById(id, dtoEscuelaCursos);
  }
}
