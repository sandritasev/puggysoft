package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstadosFilter;
import com.puggysoft.services.alcaldia.ServiceUrbanismoEstadosGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoEstadosGetFilterSize {

  @Autowired
  private ServiceUrbanismoEstadosGetFilterSize serviceUrbanismoEstadosGetFilterSize;

  @PostMapping(path = "/api/v1/urbanismo-estados/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoUrbanismoEstadosFilter dtoUrbanismoEstadosFilter,
      @PathVariable Long pageSize) {
    return serviceUrbanismoEstadosGetFilterSize.getSize(dtoUrbanismoEstadosFilter, pageSize);
  }
}