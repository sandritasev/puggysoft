package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesVenta;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesVentaCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesVentaPost {
  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesVentaCreate serviceAlcaldiaRecursosMunicipalesVentaCreate;

  @PostMapping(path = "/api/v1/alcaldia-recursos-municipales-venta")
  public ResponseEntity<String> post(
      @RequestBody @Valid DtoAlcaldiaRecursosMunicipalesVenta dtoAlcaldiaRecursosMunicipalesVenta) {
    return serviceAlcaldiaRecursosMunicipalesVentaCreate.create(dtoAlcaldiaRecursosMunicipalesVenta);
  }
}