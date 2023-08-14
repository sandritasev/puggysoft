package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipales;
import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesFilter;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesTimbresGetForVentas;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesTimbresGetForVentas {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesTimbresGetForVentas serviceAlcaldiaRecursosMunicipalesTimbresGetForVentas;

  @PostMapping(path = "/api/v1/alcaldia-recursos-municipales-timbres-ventas")
  public ResponseEntity<List<DtoAlcaldiaRecursosMunicipales>> getAlcaldiaRecursosMunicipalesFilter(
      @RequestBody @Valid DtoAlcaldiaRecursosMunicipalesFilter dtoAlcaldiaRecursosMunicipalesFilter) {
    return serviceAlcaldiaRecursosMunicipalesTimbresGetForVentas.filter(dtoAlcaldiaRecursosMunicipalesFilter);
  }
}