package com.puggysoft.dtos.alcaldia;

import java.util.List;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoAlcaldiaRecursosMunicipalesReport {

  public Double granTotal;
  public List<DtoAlcaldiaRecursosMunicipalesReportResumen> resumenVentasPorProducto;
}
