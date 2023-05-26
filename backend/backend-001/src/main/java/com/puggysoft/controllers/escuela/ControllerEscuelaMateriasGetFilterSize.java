package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaMateriasFilter;
import com.puggysoft.services.escuela.ServiceEscuelaMateriasGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaMateriasGetFilterSize {

  @Autowired
  private ServiceEscuelaMateriasGetFilterSize serviceEscuelaMateriasGetFilterSize;

  @PostMapping(path = "/api/v1/escuela-materias/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoEscuelaMateriasFilter dtoEscuelaMateriasFilter,
      @PathVariable Long pageSize) {
    return serviceEscuelaMateriasGetFilterSize.getSize(dtoEscuelaMateriasFilter,
        pageSize);
  }
}