package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesVenta;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesVentaEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesVentaPut {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesVentaEditById serviceAlcaldiaRecursosMunicipalesVentaEditById;

  @PutMapping(path = "/api/v1/alcaldia-recursos-municipales-venta/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoAlcaldiaRecursosMunicipalesVenta dtoAlcaldiaRecursosMunicipalesVenta) {
    return serviceAlcaldiaRecursosMunicipalesVentaEditById.editById(id, dtoAlcaldiaRecursosMunicipalesVenta);
  }
}
