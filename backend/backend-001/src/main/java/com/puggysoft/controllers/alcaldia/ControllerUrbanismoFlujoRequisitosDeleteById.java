package com.puggysoft.controllers.alcaldia;

import com.puggysoft.services.alcaldia.ServiceUrbanismoFlujoRequisitosDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoFlujoRequisitosDeleteById {

  @Autowired
  private ServiceUrbanismoFlujoRequisitosDeleteById serviceUrbanismoFlujoRequisitosDeleteById;

  @DeleteMapping(path = "/api/v1/urbanismo-flujo-requisitos/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceUrbanismoFlujoRequisitosDeleteById.deleteById(id);
  }
}