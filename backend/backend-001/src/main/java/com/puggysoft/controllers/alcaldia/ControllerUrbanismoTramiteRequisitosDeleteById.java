package com.puggysoft.controllers.alcaldia;

import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteRequisitosDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteRequisitosDeleteById {

  @Autowired
  private ServiceUrbanismoTramiteRequisitosDeleteById serviceUrbanismoTramiteRequisitosDeleteById;

  @DeleteMapping(path = "/api/v1/urbanismo-tramite-requisitos/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceUrbanismoTramiteRequisitosDeleteById.deleteById(id);
  }
}