package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitos;
import com.puggysoft.services.alcaldia.ServiceUrbanismoRequisitosGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoRequisitosGetById {

  @Autowired
  private ServiceUrbanismoRequisitosGetById serviceUrbanismoRequisitosGetById;

  @GetMapping(path = "/api/v1/urbanismo-requisitos/{id}")
  public ResponseEntity<DtoUrbanismoRequisitos> getById(@PathVariable Long id) {
    return serviceUrbanismoRequisitosGetById.getById(id);
  }
}
