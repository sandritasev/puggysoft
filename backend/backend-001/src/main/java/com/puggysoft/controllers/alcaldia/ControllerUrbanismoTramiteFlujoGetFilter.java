package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujo;
import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujoFilter;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteFlujoGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteFlujoGetFilter {

  @Autowired
  private ServiceUrbanismoTramiteFlujoGetFilter serviceUrbanismoTramiteFlujoGetFilter;

  @PostMapping(path = "/api/v1/urbanismo-tramite-flujo/filter")
  public ResponseEntity<List<DtoUrbanismoTramiteFlujo>> getUrbanismoTramiteFlujoFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoUrbanismoTramiteFlujoFilter dtoUrbanismoTramiteFlujoFilter) {
    return serviceUrbanismoTramiteFlujoGetFilter.filter(dtoUrbanismoTramiteFlujoFilter, page, size);
  }
}