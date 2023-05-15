package com.puggysoft.controllers.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsist;
import com.puggysoft.services.asistencia.ServiceAsistEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAsistPut {

  @Autowired
  private ServiceAsistEditById serviceAsistEditById;

  @PutMapping(path = "/api/v1/asist-control/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoAsist dtoAsist) {
    return serviceAsistEditById.editById(id, dtoAsist);
  }
}
