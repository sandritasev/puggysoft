package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujoFilter;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteFlujoGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteFlujoGetFilterSize {

  @Autowired
  private ServiceUrbanismoTramiteFlujoGetFilterSize serviceUrbanismoTramiteFlujoGetFilterSize;

  @PostMapping(path = "/api/v1/urbanismo-tramite-flujo/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoUrbanismoTramiteFlujoFilter dtoUrbanismoTramiteFlujoFilter,
      @PathVariable Long pageSize) {
    return serviceUrbanismoTramiteFlujoGetFilterSize.getSize(dtoUrbanismoTramiteFlujoFilter, pageSize);
  }
}