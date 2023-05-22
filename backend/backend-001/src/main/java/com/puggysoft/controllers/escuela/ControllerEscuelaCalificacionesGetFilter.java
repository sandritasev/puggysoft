package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCalificaciones;
import com.puggysoft.dtos.escuela.DtoEscuelaCalificacionesFilter;
import com.puggysoft.services.escuela.ServiceEscuelaCalificacionesGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCalificacionesGetFilter {

  @Autowired
  private ServiceEscuelaCalificacionesGetFilter serviceEscuelaCalificacionesGetFilter;

  @PostMapping(path = "/api/v1/escuela-calificaciones/filter")
  public ResponseEntity<List<DtoEscuelaCalificaciones>> getEscuelaCalificacionesFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoEscuelaCalificacionesFilter dtoEscuelaCalificacionesFilter) {
    return serviceEscuelaCalificacionesGetFilter.filter(dtoEscuelaCalificacionesFilter, page, size);
  }
}