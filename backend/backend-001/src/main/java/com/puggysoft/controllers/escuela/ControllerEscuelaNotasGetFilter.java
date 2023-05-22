package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotas;
import com.puggysoft.dtos.escuela.DtoEscuelaNotasFilter;
import com.puggysoft.services.escuela.ServiceEscuelaNotasGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaNotasGetFilter {

  @Autowired
  private ServiceEscuelaNotasGetFilter serviceEscuelaNotasGetFilter;

  @PostMapping(path = "/api/v1/escuela-notas/filter")
  public ResponseEntity<List<DtoEscuelaNotas>> getEscuelaNotasFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoEscuelaNotasFilter dtoEscuelaNotasFilter) {
    return serviceEscuelaNotasGetFilter.filter(dtoEscuelaNotasFilter, page, size);
  }
}