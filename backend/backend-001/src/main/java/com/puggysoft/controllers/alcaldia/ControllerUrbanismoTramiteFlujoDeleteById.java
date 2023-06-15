package com.puggysoft.controllers.alcaldia;

import com.puggysoft.services.alcaldia.ServiceUrbanismoTramiteFlujoDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUrbanismoTramiteFlujoDeleteById {

  @Autowired
  private ServiceUrbanismoTramiteFlujoDeleteById serviceUrbanismoTramiteFlujoDeleteById;

  @DeleteMapping(path = "/api/v1/urbanismo-tramite-flujo/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceUrbanismoTramiteFlujoDeleteById.deleteById(id);
  }
}