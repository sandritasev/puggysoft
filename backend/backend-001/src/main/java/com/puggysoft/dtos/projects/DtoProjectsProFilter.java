package com.puggysoft.dtos.projects;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoProjectsProFilter {

  // NOMBRE
  public String nameCriteria;
  public EnumCompareOperator nameOperator;
  // NOMBRE CORTO
  public String shortNameCriteria;
  public EnumCompareOperator shortNameOperator;
  // ESTADO
  public String statusCriteria;
  public EnumCompareOperator statusOperator;
  // DESCRIPCION
  public String descriptionCriteria;
  public EnumCompareOperator descriptionOperator;
  // RESPONSABLE
  public String responsibleCriteria;
  public EnumCompareOperator responsibleOperator;
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