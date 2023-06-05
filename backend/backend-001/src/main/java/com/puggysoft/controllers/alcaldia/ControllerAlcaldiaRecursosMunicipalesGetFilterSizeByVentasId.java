package com.puggysoft.controllers.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesFilter;
import com.puggysoft.services.alcaldia.ServiceAlcaldiaRecursosMunicipalesGetFilterSizeByVentasId;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlcaldiaRecursosMunicipalesGetFilterSizeByVentasId {

  @Autowired
  private ServiceAlcaldiaRecursosMunicipalesGetFilterSizeByVentasId serviceAlcaldiaRecursosMunicipalesGetFilter;

  // products/filter?page=${activePage - 1}&size=${pageSize}&saleId=${saleId}
  @PostMapping(path = "/api/v1/alcaldia/filter-by-ventas-id/filter/size")
  public ResponseEntity<Long> getAlcaldiaRecursosMunicipales(
      @RequestParam Long pageSize,
      @RequestParam Long ventasId,
      @RequestBody @Valid DtoAlcaldiaRecursosMunicipalesFilter dtoAlcaldiaRecursosMunicipales) {
    return serviceAlcaldiaRecursosMunicipalesGetFilter.getSize(ventasId, dtoAlcaldiaRecursosMunicipales, pageSize);
  }
}
