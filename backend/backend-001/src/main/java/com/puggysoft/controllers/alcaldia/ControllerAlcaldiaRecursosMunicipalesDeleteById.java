package com.puggysoft.controllers.alcaldia;

import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesDeleteById {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesDeleteById serviceAlcaldiaRecursosMunicipalesDeleteById;

  @DeleteMapping(path = "/api/v1/alcaldia-recursos-municipales/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceAlcaldiaRecursosMunicipalesDeleteById.deleteById(id);
  }
}