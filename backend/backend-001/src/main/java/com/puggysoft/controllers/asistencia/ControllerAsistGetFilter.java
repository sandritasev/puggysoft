package com.puggysoft.controllers.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsist;
import com.puggysoft.dtos.asistencia.DtoAsistFilter;
import com.puggysoft.services.asistencia.ServiceAsistGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAsistGetFilter {

  @Autowired
  private ServiceAsistGetFilter serviceAsistGetFilter;

  @PostMapping(path = "/api/v1/asist-control/filter")
  public ResponseEntity<List<DtoAsist>> getAsistFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoAsistFilter dtoAsistFilter) {
    return serviceAsistGetFilter.filter(dtoAsistFilter, page, size);
  }
}
