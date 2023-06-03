package com.puggysoft.dtos.alcaldia;

import java.util.List;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoAlcaldiaRecursosMunicipalesReportResumen {

  public Double ventasTotales;
  public String codigoRecursoMunicipal;
  public String nombreRecursoMunicipal;
  public List<DtoAlcaldiaRecursosMunicipalesReportItem> resumenVentas;
}
