package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitosFilter;
import com.puggysoft.services.alcaldia.ServiceUrbanismoRequisitosGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoRequisitosGetFilterSize {

  @Autowired
  private ServiceUrbanismoRequisitosGetFilterSize serviceUrbanismoRequisitosGetFilterSize;

  @PostMapping(path = "/api/v1/urbanismo-requisitos/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoUrbanismoRequisitosFilter dtoUrbanismoRequisitosFilter,
      @PathVariable Long pageSize) {
    return serviceUrbanismoRequisitosGetFilterSize.getSize(dtoUrbanismoRequisitosFilter, pageSize);
  }
}