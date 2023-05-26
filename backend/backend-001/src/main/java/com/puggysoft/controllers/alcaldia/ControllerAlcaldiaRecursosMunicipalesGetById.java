package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipales;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesGetById {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesGetById serviceAlcaldiaRecursosMunicipalesGetById;

  @GetMapping(path = "/api/v1/alcaldia-recursos-municipales/{id}")
  public ResponseEntity<DtoAlcaldiaRecursosMunicipales> getById(@PathVariable Long id) {
    return serviceAlcaldiaRecursosMunicipalesGetById.getById(id);
  }
}
