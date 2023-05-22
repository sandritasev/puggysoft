package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaMaterias;
import com.puggysoft.dtos.escuela.DtoEscuelaMateriasFilter;
import com.puggysoft.services.escuela.ServiceEscuelaMateriasGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaMateriasGetFilter {

  @Autowired
  private ServiceEscuelaMateriasGetFilter serviceEscuelaMateriasGetFilter;

  @PostMapping(path = "/api/v1/escuela-materias/filter")
  public ResponseEntity<List<DtoEscuelaMaterias>> getEscuelaMateriasFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoEscuelaMateriasFilter dtoEscuelaMateriasFilter) {
    return serviceEscuelaMateriasGetFilter.filter(dtoEscuelaMateriasFilter, page, size);
  }
}