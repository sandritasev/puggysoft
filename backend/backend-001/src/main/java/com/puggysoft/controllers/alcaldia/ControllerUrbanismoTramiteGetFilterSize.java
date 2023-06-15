package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFilter;
import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteGetFilterSize {

  @Autowired
  private ServiceUrbanismoTramiteGetFilterSize serviceUrbanismoTramiteGetFilterSize;

  @PostMapping(path = "/api/v1/urbanismo-tramite/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoUrbanismoTramiteFilter dtoUrbanismoTramiteFilter,
      @PathVariable Long pageSize) {
    return serviceUrbanismoTramiteGetFilterSize.getSize(dtoUrbanismoTramiteFilter, pageSize);
  }
}