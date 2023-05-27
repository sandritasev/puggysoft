package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCalificacionesFilter;
import com.puggysoft.services.escuela.ServiceEscuelaCalificacionesGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCalificacionesGetFilterSize {

  @Autowired
  private ServiceEscuelaCalificacionesGetFilterSize serviceEscuelaCalificacionesGetFilterSize;

  @PostMapping(path = "/api/v1/escuela-calificaciones/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoEscuelaCalificacionesFilter dtoEscuelaCalificacionesFilter,
      @PathVariable Long pageSize) {
    return serviceEscuelaCalificacionesGetFilterSize.getSize(dtoEscuelaCalificacionesFilter,
        pageSize);
  }
}