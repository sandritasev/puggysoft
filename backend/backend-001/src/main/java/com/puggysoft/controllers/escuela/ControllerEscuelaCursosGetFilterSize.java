package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursosFilter;
import com.puggysoft.services.escuela.ServiceEscuelaCursosGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosGetFilterSize {

  @Autowired
  private ServiceEscuelaCursosGetFilterSize serviceEscuelaCursosGetFilterSize;

  @PostMapping(path = "/api/v1/escuela-cursos/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoEscuelaCursosFilter dtoEscuelaCursosFilter,
      @PathVariable Long pageSize) {
    return serviceEscuelaCursosGetFilterSize.getSize(dtoEscuelaCursosFilter,
        pageSize);
  }
}