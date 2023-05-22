package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaMaterias;
import com.puggysoft.services.escuela.ServiceEscuelaMateriasCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaMateriasPost {
  @Autowired
  private ServiceEscuelaMateriasCreate serviceEscuelaMateriasCreate;

  @PostMapping(path = "/api/v1/escuela-materias")
  public ResponseEntity<String> post(@RequestBody @Valid DtoEscuelaMaterias dtoEscuelaMaterias) {
    return serviceEscuelaMateriasCreate.create(dtoEscuelaMaterias);
  }
}