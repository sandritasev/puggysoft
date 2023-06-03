package com.puggysoft.dtos.alcaldia;

import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipalesReportItem;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoAlcaldiaRecursosMunicipalesReportItem {

  public Long numeroVenta;
  public Double ingresoVenta;

  /**
   *
   * @param entity entity.
   * @return dto.
   */
  public static DtoAlcaldiaRecursosMunicipalesReportItem entityToDto(
      EntityAlcaldiaRecursosMunicipalesReportItem entity) {
    DtoAlcaldiaRecursosMunicipalesReportItem dto = new DtoAlcaldiaRecursosMunicipalesReportItem();
    dto.setNumeroVenta(entity.getNumeroVenta());
    dto.setIngresoVenta(entity.getIngresoVenta());
    return dto;
  }
}
