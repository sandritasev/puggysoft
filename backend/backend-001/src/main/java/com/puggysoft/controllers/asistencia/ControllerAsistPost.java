package com.puggysoft.controllers.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsist;
import com.puggysoft.services.asistencia.ServiceAsistCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAsistPost {
  @Autowired
  private ServiceAsistCreate serviceAsistCreate;

  @PostMapping(path = "/api/v1/asist-control")
  public ResponseEntity<String> post(@RequestBody @Valid DtoAsist dtoAsist) {
    return serviceAsistCreate.create(dtoAsist);
  }
}
