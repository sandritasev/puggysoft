package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipales;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesPut {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesEditById serviceAlcaldiaRecursosMunicipalesEditById;

  @PutMapping(path = "/api/v1/alcaldia-recursos-municipales/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoAlcaldiaRecursosMunicipales dtoAlcaldiaRecursosMunicipales) {
    return serviceAlcaldiaRecursosMunicipalesEditById.editById(id, dtoAlcaldiaRecursosMunicipales);
  }
}
