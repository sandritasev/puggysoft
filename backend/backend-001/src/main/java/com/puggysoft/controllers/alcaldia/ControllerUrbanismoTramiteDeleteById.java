package com.puggysoft.controllers.alcaldia;

import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteDeleteById {

  @Autowired
  private ServiceUrbanismoTramiteDeleteById serviceUrbanismoTramiteDeleteById;

  @DeleteMapping(path = "/api/v1/urbanismo-tramite/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceUrbanismoTramiteDeleteById.deleteById(id);
  }
}