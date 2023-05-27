package com.puggysoft.controllers.alcaldia;

import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesVentaDetalleDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesVentaDetalleDeleteById {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesVentaDetalleDeleteById serviceAlcaldiaRecursosMunicipalesVentaDetalleDeleteById;

  @DeleteMapping(path = "/api/v1/alcaldia-recursos-municipales-venta-detalle/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceAlcaldiaRecursosMunicipalesVentaDetalleDeleteById.deleteById(id);
  }
}