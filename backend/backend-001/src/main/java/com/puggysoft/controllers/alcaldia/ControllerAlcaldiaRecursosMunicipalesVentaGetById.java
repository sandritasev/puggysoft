package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesVenta;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesVentaGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesVentaGetById {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesVentaGetById serviceAlcaldiaRecursosMunicipalesVentaGetById;

  @GetMapping(path = "/api/v1/alcaldia-recursos-municipales-ventas/{id}")
  public ResponseEntity<DtoAlcaldiaRecursosMunicipalesVenta> getById(@PathVariable Long id) {
    return serviceAlcaldiaRecursosMunicipalesVentaGetById.getById(id);
  }
}
