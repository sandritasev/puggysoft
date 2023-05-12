package com.puggysoft.dtos.pets;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoPetsHistorialFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // DIAGNOSTICO
  public String diagnosticoCriteria;
  public EnumCompareOperator diagnosticoOperator;
  // TRATAMIENTO
  public String tratamientoCriteria;
  public EnumCompareOperator tratamientoOperator;
  // WEIGHT
  public String weightCriteria;
  public EnumCompareOperator weightOperator;
  // PET_ID
  public String petIdCriteria;
  public EnumCompareOperator petIdOperator;
  // TENANT
  public String tenantCriteria;
  public EnumCompareOperator tenantOperator;
  // CREATED BY
  @Size(max = 20)
  public String createdByCriteria;
  public EnumCompareOperator createdByOperator;
  // UPDATED BY
  @Size(max = 20)
  public String updatedByCriteria;
  public EnumCompareOperator updatedByOperator;
  // CREATION DATE
  public String creationDateCriteria;
  public EnumCompareOperator creationDateOperator;
  // UPDATED DATE
  public String updateDateCriteria;
  public EnumCompareOperator updateDateOperator;
}