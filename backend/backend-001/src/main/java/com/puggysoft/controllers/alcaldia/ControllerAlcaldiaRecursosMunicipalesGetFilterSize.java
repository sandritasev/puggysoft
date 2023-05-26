package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesFilter;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesGetFilterSize {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesGetFilterSize serviceAlcaldiaRecursosMunicipalesGetFilterSize;

  @PostMapping(path = "/api/v1/alcaldia-recursos-municipales/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoAlcaldiaRecursosMunicipalesFilter dtoAlcaldiaRecursosMunicipalesFilter,
      @PathVariable Long pageSize) {
    return serviceAlcaldiaRecursosMunicipalesGetFilterSize.getSize(dtoAlcaldiaRecursosMunicipalesFilter, pageSize);
  }
}