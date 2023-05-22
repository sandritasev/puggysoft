package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaMaterias;
import com.puggysoft.services.escuela.ServiceEscuelaMateriasEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaMateriasPut {

  @Autowired
  private ServiceEscuelaMateriasEditById serviceEscuelaMateriasEditById;

  @PutMapping(path = "/api/v1/escuela-materias/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoEscuelaMaterias dtoEscuelaMaterias) {
    return serviceEscuelaMateriasEditById.editById(id, dtoEscuelaMaterias);
  }
}
