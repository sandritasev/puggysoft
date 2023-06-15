package com.puggysoft.dtos.alcaldia;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoUrbanismoTramiteFlujoFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // TRAMITE NOMBRE CORTO
  public String tramiteNombreCortoCriteria;
  public EnumCompareOperator tramiteNombreCortoOperator;
  // ESTADO NOMBRE CORTO
  public String estadoNombreCortoCriteria;
  public EnumCompareOperator estadoNombreCortoOperator;
  // NOMBRE CLIENTE
  public String nombreClienteCriteria;
  public EnumCompareOperator nombreClienteOperator;
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