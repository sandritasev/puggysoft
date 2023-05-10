package com.puggysoft.controllers.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsist;
import com.puggysoft.services.asistencia.ServiceAsistGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAsistGetById {

  @Autowired
  private ServiceAsistGetById serviceAsistGetById;

  @GetMapping(path = "/api/v1/asist-control/{id}")
  public ResponseEntity<DtoAsist> getById(@PathVariable Long id) {
    return serviceAsistGetById.getById(id);
  }
}
