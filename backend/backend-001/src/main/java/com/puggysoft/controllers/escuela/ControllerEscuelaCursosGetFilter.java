package com.puggysoft.controllers.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursos;
import com.puggysoft.dtos.escuela.DtoEscuelaCursosFilter;
import com.puggysoft.services.escuela.ServiceEscuelaCursosGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEscuelaCursosGetFilter {

  @Autowired
  private ServiceEscuelaCursosGetFilter serviceEscuelaCursosGetFilter;

  @PostMapping(path = "/api/v1/escuela-cursos/filter")
  public ResponseEntity<List<DtoEscuelaCursos>> getEscuelaCursosFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoEscuelaCursosFilter dtoEscuelaCursosFilter) {
    return serviceEscuelaCursosGetFilter.filter(dtoEscuelaCursosFilter, page, size);
  }
}