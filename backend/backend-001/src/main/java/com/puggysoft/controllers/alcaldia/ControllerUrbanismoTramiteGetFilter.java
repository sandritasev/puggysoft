package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFilter;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteGetFilter {

  @Autowired
  private ServiceUrbanismoTramiteGetFilter serviceUrbanismoTramiteGetFilter;

  @PostMapping(path = "/api/v1/urbanismo-tramite/filter")
  public ResponseEntity<List<DtoUrbanismoTramite>> getUrbanismoTramiteFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoUrbanismoTramiteFilter dtoUrbanismoTramiteFilter) {
    return serviceUrbanismoTramiteGetFilter.filter(dtoUrbanismoTramiteFilter, page, size);
  }
}