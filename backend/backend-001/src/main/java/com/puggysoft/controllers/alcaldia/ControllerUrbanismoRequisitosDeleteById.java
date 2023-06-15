package com.puggysoft.controllers.alcaldia;

import com.puggysoft.services.alcaldia.ServiceUrbanismoRequisitosDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoRequisitosDeleteById {

  @Autowired
  private ServiceUrbanismoRequisitosDeleteById serviceUrbanismoRequisitosDeleteById;

  @DeleteMapping(path = "/api/v1/urbanismo-requisitos/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceUrbanismoRequisitosDeleteById.deleteById(id);
  }
}