package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitos;
import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitosFilter;
import com.puggysoft.services.alcaldia.ServiceUrbanismoRequisitosGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoRequisitosGetFilter {

  @Autowired
  private ServiceUrbanismoRequisitosGetFilter serviceUrbanismoRequisitosGetFilter;

  @PostMapping(path = "/api/v1/urbanismo-requisitos/filter")
  public ResponseEntity<List<DtoUrbanismoRequisitos>> getUrbanismoRequisitosFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoUrbanismoRequisitosFilter dtoUrbanismoRequisitosFilter) {
    return serviceUrbanismoRequisitosGetFilter.filter(dtoUrbanismoRequisitosFilter, page, size);
  }
}