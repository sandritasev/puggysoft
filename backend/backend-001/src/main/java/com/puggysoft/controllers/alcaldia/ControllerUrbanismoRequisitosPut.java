package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitos;
import com.puggysoft.services.alcaldia.ServiceUrbanismoRequisitosEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoRequisitosPut {

  @Autowired
  private ServiceUrbanismoRequisitosEditById serviceUrbanismoRequisitosEditById;

  @PutMapping(path = "/api/v1/urbanismo-requisitos/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoUrbanismoRequisitos dtoUrbanismoRequisitos) {
    return serviceUrbanismoRequisitosEditById.editById(id, dtoUrbanismoRequisitos);
  }
}
