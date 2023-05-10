package com.puggysoft.controllers.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsistFilter;
import com.puggysoft.services.asistencia.ServiceAsistGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAsistGetFilterSize {

  @Autowired
  private ServiceAsistGetFilterSize serviceAsistGetFilterSize;

  @PostMapping(path = "/api/v1/asist-control/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoAsistFilter dtoAsistFilter, @PathVariable Long pageSize) {
    return serviceAsistGetFilterSize.getSize(dtoAsistFilter, pageSize);
  }
}
