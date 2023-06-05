package com.puggysoft.dtos.alcaldia;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoAlcaldiaRecursosMunicipalesFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // CODIGO
  public String codigoCriteria;
  public EnumCompareOperator codigoOperator;
  // CANTIDAD
  public String cantidadCriteria;
  public EnumCompareOperator cantidadOperator;
  // NAME
  public String nameCriteria;
  public EnumCompareOperator nameOperator;
  // PRECIO
  public String precioCriteria;
  public EnumCompareOperator precioOperator;
  // TENANT
  public String tenantCriteria;
  public EnumCompareOperator tenantOperator;
  // CREATED BY
  @Size(max = 30)
  public String createdByCriteria;
  public EnumCompareOperator createdByOperator;
  // UPDATED BY
  @Size(max = 30)
  public String updatedByCriteria;
  public EnumCompareOperator updatedByOperator;
  // CREATION DATE
  public String creationDateCriteria;
  public EnumCompareOperator creationDateOperator;
  // UPDATED DATE
  public String updateDateCriteria;
  public EnumCompareOperator updateDateOperator;
}