package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstadosFilter;
import com.puggysoft.services.alcaldia.ServiceUrbanismoEstadosGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoEstadosGetFilter {

  @Autowired
  private ServiceUrbanismoEstadosGetFilter serviceUrbanismoEstadosGetFilter;

  @PostMapping(path = "/api/v1/urbanismo-estados/filter")
  public ResponseEntity<List<DtoUrbanismoEstados>> getUrbanismoEstadosFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoUrbanismoEstadosFilter dtoUrbanismoEstadosFilter) {
    return serviceUrbanismoEstadosGetFilter.filter(dtoUrbanismoEstadosFilter, page, size);
  }
}