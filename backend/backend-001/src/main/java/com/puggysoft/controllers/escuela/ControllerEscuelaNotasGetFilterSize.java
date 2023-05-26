package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotasFilter;
import com.puggysoft.services.escuela.ServiceEscuelaNotasGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaNotasGetFilterSize {

  @Autowired
  private ServiceEscuelaNotasGetFilterSize serviceEscuelaNotasGetFilterSize;

  @PostMapping(path = "/api/v1/escuela-notas/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoEscuelaNotasFilter dtoEscuelaNotasFilter,
      @PathVariable Long pageSize) {
    return serviceEscuelaNotasGetFilterSize.getSize(dtoEscuelaNotasFilter,
        pageSize);
  }
}